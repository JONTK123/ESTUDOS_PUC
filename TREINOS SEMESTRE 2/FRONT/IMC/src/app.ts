// Importar a biblioteca express, módulo express, que possui funções para criar um servidor WEB
import express from "express";

const app = express(); // ?
const port = 5000; // Qual porta o servidor ira ouvir as REQ dos clientes

// Iniciar o servidor na porta especificada (3000) e exibir uma mensagem no console
app.listen(port, () => {
  console.log("Server running...");
});

app.use(express.json()); // Permite o servidor LER solicitações do cliente no formato JSON.

app.post("/imc", (req, res) => { // Define a rota do servidor. Quando usuario fizer a solicitação ( POST /IMC ) = REQ o RES ira ser executado que esta dentro do corpo desse bloco de codigo.

  const peso = req.body.peso; // Faço um requerimento de uma variavel peso que ira para o corpo da solicitação
  const altura = req.body.altura; // "
  let imc = undefined; // Variavel temporaria sem valor definido
  let message = ""; // " string vazia
  let status = "ERROR"; // "

  // Verificar se os parâmetros peso e altura foram fornecidos
  if (peso !== undefined && altura !== undefined) {
    // Verificar se peso e altura são maiores que zero
    if (peso > 0 && altura > 0) {
      // Realizar o cálculo do IMC
      imc = peso / Math.pow(altura, 2);
      status = "SUCCESS";
    } else {
      // Tratar casos em que peso e/ou altura são menores ou iguais a zero
      if (peso <= 0 && altura <= 0) {
        message = "Peso e altura devem ser maiores que zero";
      } else if (peso <= 0) {
        message = "Peso deve ser maior que zero";
      } else {
        message = "Altura deve ser maior que zero";
      }
    }
  } else {
    // Caso os parâmetros peso e altura não tenham sido fornecidos
    message = "Parâmetros peso e altura devem ser fornecidos";
  }

  // Preparar a resposta em formato JSON, modelo de resposta formato conveniente para envio de resposta a uma olicitação recebida via HTTP
  let response = { 
    status: status,
    imc: imc,
    message: message,
  };

  // Enviar a resposta JSON ao cliente
  res.send(response);
});

