const express = require('express');
const app = express();
const cors = require('cors');
const PORT = 55555;

app.use(express.json());
app.use(cors());

let orders = [
    {
        id: 1,
        customerName: "Azar",
        totalPrice: 150.0
    }
];

app.get("/", (req, res) => {
    res.send("express server up and running");
});

// GET all orders
app.get("/orders", (req, res) => {
    res.send(orders);
});

// GET order by ID
app.get("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);
    
    const order = orders.find(o => o.id === id);
    if (!order) {
        return res.status(404).send({ message: "Order not found" });
    }

    res.send(order);
});

// POST create new order
app.post("/orders", validateOrder, (req, res) => {
    const { customerName, totalPrice } = req.body;
    
    const newOrder = {
        id: orders.length > 0 ? Math.max(...orders.map(o => o.id)) + 1 : 1,
        customerName,
        totalPrice
    };

    orders.push(newOrder);
    res.status(201).send(newOrder);
});

// PUT update order
app.put("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const { customerName, totalPrice } = req.body;

    const orderIndex = orders.findIndex(o => o.id === id);
    if (orderIndex === -1) {
        return res.status(404).send({ message: "Order not found" });
    }

    orders[orderIndex] = {
        id,
        customerName,
        totalPrice
    };

    res.send(orders[orderIndex]);
});

// DELETE delete order
app.delete("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);

    const initialLength = orders.length;
    orders = orders.filter(o => o.id !== id);

    if (orders.length === initialLength) {
        return res.status(404).send({ message: "Order not found" });
    }

    res.status(200).send({ message: "Order deleted successfully" });
});

app.listen(PORT, () => {
    console.log(`express server running on localhost:${PORT}`);
});