//Iporters
import express from "express"; //importar biblioteca express?


//Global variables
const app = express(); //Nosso app sera construido pelo modulo express e suas funções
const port = 3000;

//Usar dialeto JSON para poder definir o tipo de requisição e funcionar
app.use(express.json());

//Routes of my service
//app.post("/imc",(req,res)=>{

    //put your code here - of service /imc ( serviço de calculo IMC )  ( onde coloca seus codigos para suas funções )
    //all services must be have: INPUT (by req parameter) and ENTRADA - REQ ( INTEGRADOR - insira o numero aviao etc)
    //OUTPUT (result of the service) by res parameter. SAIDA - RES


// O PROGRAMA IMC, SERVIÇO DEVE RETORNAR SEMPRE O STATUS, RESULTADO E MESSAGE. SE DEU CERTO OU ERRADO
// E O VALOR. MESMO QUE SEJA EM UMA SITUAÇÃO DE ERRO. COMO DIVISÃO POR 0

// First, in the REQ it needs to receive 2 parameters, weith ans height.
// Secondly, validate tehe 2 parameters ARRIVED ( if not, return error )
// Thirdly, If both of them are bigger than 0
// Fourth, If its bigger than 0, realizes the calculation and return the result.
// Fith, If not, treat each case individually.

// Read, weight and height ( parameter. )

// Diferentes metodos de enviar paramtros para requisição, header ( senhas ), body ( eh para dados gerais )

// estudar verbos get, post
// etudar tipos de requisição

//});


app.post("/imc",(req,res)=>{
const peso = req.body.peso;
const altura = req.body.altura;
let imc = undefined;
let message: string = "";
let status: string = "ERROR";


    if(peso !== undefined && altura !== undefined){
        if(peso > 0 && altura > 0){
            //Fazer Calculo
            imc = peso / Math.pow(altura,2);
            status = "SUCCESS";
        }else{
            if(peso <= 0 && altura <= 0){
                message = "Peso e altura devem ser maiores que zero";

            }else if(peso <= 0){
                message = "Peso deve ser maior que zero";
            } else {
                message = "Altura deve ser maior que zero"
            }
        }
    }
    else{
        message = "Parametros peso e altura devem ser fornecidos";
    }


    //LET essa variavel so funciona dentro do seriviço

    let r = { 
        status: status, //STATUS: EH O PRINT?
        imc: imc,
        message: message,
    };

    res.send(r);

});

app.listen(port,()=>{
    console.log("Server running...")
});
