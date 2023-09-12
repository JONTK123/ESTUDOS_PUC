import express from "express";

// aplicacao backend web, com framework express.
const app = express();
const port = 3000;

app.get("/", (req, res) =>{
    res.send("Estou funcionando... na rota default /.");
});

app.get("/clientes", (req, res)=>{
    res.send("Listagem dos clientes cadastrados, vai aparecer aqui...");
});

// nao esquecer de implementar um listen para saber que o servidor esta de pe.
app.listen(port, ()=>{
    console.log(`HTTP Server started on ${port} port`);
});