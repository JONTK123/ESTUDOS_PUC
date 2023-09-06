// importando um pacote express
//para provisionar um servidor HTTP pronto
import express from "express";

// criando uma constante que representa um servidor
const app = express();
// criando uma constante que representa qual porta o servidor usara
const port = 3000; 

// definindo as ROTAS de serviços.
app.get('/', (req,res) =>{

    res.send("Rota default - oi");
});

app.get('/piAoQuadrado', (req,res) => {

    const pi:number = 3.1415;
    const quadradoDePi = Math.pow(pi,2);
    res.send(`O quadrado de pi é: ${quadradoDePi}`);
});

//Fazer um serviço (por ROTA) cpaz de calcular o IMC, porém os parametros de entrada
// que é peso e altura, precisam ser recebidos na rota.
// Para testar o serviço use o POSTMA.

app.post("/imc", (req,res) => {

    //Codigo uqe recebe os parametros, calcula e devolve o resultado.

});

app.listen(port, ()=>{

    console.log(`Servidor HTTP rodando na porta: ${port}`);
});