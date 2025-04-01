const WebSocket = require('ws')
const server = new WebSocket.Server({port: 55555})

let socketConnections = []

server.on('connection', (ws) => {
    socketConnections.push(ws)  
    console.log(`Client Connected | ${socketConnections.length}`)

    ws.on('message', (data) => {
        const msg = data.toString()
        console.log(`Client Msg: ${msg}`)

        for(client of socketConnections) {
            if(client.readyState == WebSocket.OPEN) {
                client.send(msg)
            }
        }
    })

    ws.on('close', (ws) => {
        socketConnections = socketConnections.filter((s) => s != ws)
        console.log(`Client Disconnected | ${socketConnections.length}`)
    })
})

console.log("Socket open at ws://localhost:55555")