const ws = require("ws");
const server = new ws.Server({port: 8080});

const mongoose = require('mongoose')
mongoose.connect('mongodb://simmu:meowgosling@localhost:27017/employeeDB?authSource=admin')
.then(() => console.log("connected to mongodb"))
.catch(() => console.log("gone ur mongodb"))

const employeeSchema = new mongoose.Schema({
    id: Number,
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

const Employee = mongoose.model("employee", employeeSchema)

async function handler(msg) {
    const data = msg.toString().split(" ");

    if(data[0] == "INSERT") {
        if(!Number.isInteger(parseInt(data[2]))) {
            return "Invalid salary";
        }

        const allEmp = await Employee.find({}, {_id: 0, __v: 0});

        const emp = new Employee({
            id: allEmp.length + 1,
            name: data[1],
            salary: parseInt(data[2]),
            role: data[3],
            department: data[4],
            experience: parseInt(data[5])
        });

        await emp.save()

        return "Employee inserted successfully."
    } else if(data[0] == "RETRIEVE") {
        let reply = ""
        const data = await Employee.find({}, {_id: 0, __v: 0})
        data.forEach(u => {
            reply += `ID: ${u.id}, Name: ${u.name}, Salary: ${u.salary}, Role: ${u.role}, Department: ${u.department}, Experience: ${u.experience} years\n`
        });

        return reply;
    } else if(data[0] == "RETRIEVE_BY_DEPT") {
        const department = data[1]

        let reply = ""
        const emp = await Employee.find({department}, {_id: 0, __v: 0})
        emp.forEach(u => {
            reply += `ID: ${u.id}, Name: ${u.name}, Salary: ${u.salary}, Role: ${u.role}, Department: ${u.department}, Experience: ${u.experience} years\n`
        });

        return reply;
    } else {
        return "Invalid command."
    }
}

server.on("connection", (socket) => {
    console.log("client connected!");

    socket.on("message", async (msg) => {
        socket.send(await handler(msg));
    })

    socket.on("close", () => {
        console.log("client disconnected.");
    })
})

console.log("Websocket server running at ws://localhost:8080");