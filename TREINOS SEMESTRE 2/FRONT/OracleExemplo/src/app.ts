import express from "express"; //Apelido express, importar funcoes da biblioteca express
import oracledb from "oracledb";
import dotenv from "dotenv"; //Criacao de um arquivo separado para senhas e nomes de usuarios

const app = express(); //A variavel APP vai ser responsavel por utilizar as funcoes da biblioteca express
const port = 3000; //Const = variavel imutavel, let = variavel so para determinada funcao,  

// conexão com o BD.
const oracleStr = "......."; //Comando de conexao da sua conta oracle cloud, string de conexao

app.use(express.json()); //Codigo padrao para iniciar os comandos, sei la, vai utilizar os dados do pacote jason

app.get("/obterAeronaves", async(req, res)=>{ //A funcao get significa que nao iremos pegar dados de nenhum local, async = rodar num tempo != do tempo do banco de dados

    dotenv.config(); //Um arquivo com informacoes de usuario e senha do orcale

    let result = undefined; //Variavel que sera usado somente nesta funcao get, dps ela some

    const connection = await oracledb.getConnection({ //await espera rodar todo esse bloco de atividades
        // Apenas para testes vamos deixar a senha aqui.
        user: process.env.ORACLE_USER, //Processar o que esta dentro da .env
        password: process.env.ORACLE_PASSWORD,  //Processar o que esta dentro da .env
        connectionString: oracleStr, //Conectar usuario, senha nesta conexao na variavel que criamos acima
    });
    try{
        //Tentando obter os dados...
        result = await connection.execute('SELECT * FROM AERONAVE'); //Atribuir a variavel result, essa funcao do banco que temos que esperar
    }catch (erro){ //Try except, tenta ali mas se nao der ele define uma variavel ERRO
        if (erro instanceof Error){ //se variavel ERRO for um erro conhecido
            console.log(O detalhamento do erro é: ${erro.message}) //console.log PRINTAR no log ( bloco de texto ) ou ( terminal do vscode ) mas nao mostra isso par ao usuario
        }else{
            console.log("Erro desconhecido") // console.log é uma impressão do log (console) do pc
        }
        result ={
            error: "Erro ao obter aeronaves", //struct para printar msg igual IMC
        }
    }finally{ //So vai para o finally se der certo o try primeiro
        if(connection){ //Se conexao tiver ativo, connection definido previamente como 1
            try{
                await connection.close();
            }catch(err){
                console.error(err);
            }
        }
        res.send(result);
    }
});

app.put("/incluirAeronave", (req,res)=>{
    // incluir a aeronave no oracle...
});


app.put("/excluirAeronave", (req, res)=>{
    // excluir a aeronave do Oracle...
});

app.listen(port, ()=>{
    console.log("Servidor HTTP RODANDO!");
});
// .
// .
// .
// .
// .
// .
// .
//codigo base JS para criar o TS no projeto lá em cima...
const oracledb = require('oracledb');
async function runApp()
{
  let connection;
  try {
    // Use the connection string copied from the cloud console
    // and stored in connstring.txt file from Step 2 of this tutorial
    connection = await oracledb.getConnection({ user: "admin", password: "XXXX", connectionString: "(description=...)" });
    
    // Create a table
    await connection.execute(begin execute immediate 'drop table nodetab'; exception when others then if sqlcode <> -942 then raise; end if; end;);
    await connection.execute(create table nodetab (id number, data varchar2(20)));
    
    // Insert some rows
    const sql = INSERT INTO nodetab VALUES (:1, :2);
    const binds = [ [1, "First" ], [2, "Second" ], [3, "Third" ], [4, "Fourth" ], [5, "Fifth" ], [6, "Sixth" ], [7, "Seventh" ] ];
    await connection.executeMany(sql, binds);
    // connection.commit(); // uncomment to make data persistent
    
    // Now query the rows back
    const result = await connection.execute(SELECT * FROM nodetab);
    console.dir(result.rows, { depth: null });
  } catch (err) {
    console.error(err);
  } finally {
    if (connection)
      {
        try {
          await connection.close();
        } catch (err) {
          console.error(err);
      }
    }
  }
}
runApp();