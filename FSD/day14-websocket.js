const ws = require("ws");
const server = new ws.Server({port: 8080});

let users = []

function handler(msg) {
    const data = msg.toString().split(" ");

    if(data[0] == "INSERT") {
        users.push({
            ID: users.length + 1,
            Name: data[1],
            Salary: parseInt(data[2])
        });

        return "Employee inserted successfully."
    } else if(data[0] == "RETRIEVE") {
        let reply = ""
        users.forEach(u => {
            reply += `ID: ${u.ID}, Name: ${u.Name}, Salary: ${u.Salary}\n`
        });

        return reply;
    } else {
        return "Invalid command."
    }
}

server.on("connection", (socket) => {
    console.log("client connected!");

    socket.on("message", (msg) => {
        socket.send(handler(msg));
    })

    socket.on("close", () => {
        console.log("client disconnected.");
    })
})

console.log("Websocket server running at ws://localhost:8080");