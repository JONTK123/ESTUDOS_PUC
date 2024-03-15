// Adicionando Elementos e Verificando Existência:
// Crie um programa que solicite ao usuário que insira nomes de pessoas até que ele digite "fim". Em seguida, imprima todos os nomes inseridos.

//EX1
fun main(){
    var lista = emptyArray<String>() //Ao inicializar um array vazio, especificar o tipo igual list
    var resp = "" //Embora estou declarando o valor da variavel ao longo do codigo, como ele esta no while, eh necessario atribuir um valor e nao deixa-lo indefinido
    var nome: String //ISTO ESTA INDEFINIDO E NAO VAZIO
	//r nome: String? = null esta vazio
    var nome2: String

 do {
        println("Digite um nome para adicionar na lista: ")
        nome = readLine() ?: "" 
     
        if (nome != null && nome.isNotEmpty()) { 
            lista += nome
            println("Deseja adicionar mais um nome? (s para continuar ou Fim para encerrar)")
        	resp = readLine() ?: ""
        }
        
    } while (resp.equals("s", ignoreCase = true)) //Manipulacao de string, tambem temos str.lenght, str.Equals str.toUpperCase etcetct
 
        lista.forEachIndexed { index, nome -> //Nao da para simplesmente dar print(array) tem que usar forEachIndexed ( index e o item/nome) array.Contains array.copyOf()
        println("$index: $nome")}
	}

    //RESUMO DO Q EU VI

    fun main() {
        var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
        var riverArray2 = riversArray.copyOf() + "biase" //Para adicionar
        var riverArray3 = riverArray2.filter { it != "biase" }.toTypedArray() //Para retirar Usar filtro e se o item do array != "biase" escreve os items do array dentro.
        var resp: String = ""
        var resp2: String = ""
    
        
        println("riverArray2:")
        riverArray2.forEachIndexed { index, river ->
            println("$index: $river")
        }
        
        println("\nriverArray3:")
        riverArray3.forEachIndexed { index, river ->
            println("$index: $river")
        }
        
        
        if ( riverArray3[2] == "Yangtze" ){
            println("ebbaaa sexo")
        }
        
           do {
            println("Deseja continuar?")
            resp = readLine() ?: "" //-> se resultado igual vazio ( usuario nao preenhceu ) assumir que vale " "
            
        } while (resp.equals("s", ignoreCase = true))
        
        println("Deseja continuar?")
        resp2 = readLine() ?: "" //-> se resultado igual vazio ( usuario nao preenhceu ) assumir que vale " 
        
        while (resp2.equals("s", ignoreCase = true)) {
            
        }
    }
    