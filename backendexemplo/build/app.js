"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
// importando um pacote express
//para provisionar um servidor HTTP pronto
const express_1 = __importDefault(require("express"));
// criando uma constante que representa um servidor
const app = (0, express_1.default)();
// criando uma constante que representa qual porta o servidor usara
const port = 3000;
// definindo as ROTAS de serviços.
app.get('/', (req, res) => {
    res.send("Rota default - oi");
});
app.get('/piAoQuadrado', (req, res) => {
    const pi = 3.1415;
    const quadradoDePi = Math.pow(pi, 2);
    res.send(`O quadrado de pi é: ${quadradoDePi}`);
});
app.listen(port, () => {
    console.log(`Servidor HTTP rodando na porta: ${port}`);
});
