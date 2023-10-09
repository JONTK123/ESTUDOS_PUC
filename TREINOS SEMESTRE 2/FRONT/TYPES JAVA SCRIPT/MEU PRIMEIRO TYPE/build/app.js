"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
// aplicacao backend web, com framework express.
const app = (0, express_1.default)();
const port = 3000;
app.get("/", (req, res) => {
    res.send("Estou funcionando... na rota default /.");
});
app.get("/clientes", (req, res) => {
    res.send("Listagem dos clientes cadastrados, vai aparecer aqui...");
});
// nao esquecer de implementar um listen para saber que o servidor esta de pe.
app.listen(port, () => {
    console.log(`HTTP Server started on ${port} port`);
});
