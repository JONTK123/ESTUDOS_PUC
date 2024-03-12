//Operações basicas 65

// fun main() {
// 	var costumers = 10
    
//     costumers = 8 //Nao precisa especificar int
    
//     costumers = costumers + 3 //11 -> passa a ser novo valor
//     costumers += 7 //18
//     costumers -= 3 //15
//     costumers *= 2 //30
//     costumers /= 3 //3

//     val a: int = 200
    
//     println(costumers)
// }

// -----------------------------------------------

//Collections 67 - 68

//map: Transforma cada elemento da coleção usando uma função e retorna uma nova coleção com os resultados.
//filter: Retorna uma nova coleção contendo apenas os elementos que satisfazem a condição especificada em uma função.
// groupBy: Agrupa os elementos da coleção em mapas com base em uma função de chave.
// forEach: Executa uma ação para cada elemento da coleção sem retornar um valor.

//read-only list - listOf() function.
//mutable list - mutableListOf() function.

// fun main() {
//     val lista = listfOf("coco", "xixi") //Jeito rapido
//     println(lista)
    
//     //lista2 = imutavel mas elementos dentro sao mutaveis ( add ou remover )
//     val lista2: MutableList<string> = mutableListOf("cococo", "xixixi") //Jeito lento, delarar o tipo primeiro MutableList<string> dps seu valor mutableListOf
//     println(lista2)
    
//     //Transformar um mutavel em readonly - casting
//     val lista2: MutableList<String> = mutableListOf("cococo", "xixixi")
//     val lista3: List<String> = lista2 //copia da lista2
    
// // {} .first() .last() .count() inOperator .add() .remove()
//     val wukongList: MutableList<String> = mutableListOf("wukong", "suporte")
//     println("O primeiro item: ${wukongList[0]}")
//     println("O primeiro item: ${wukongList.first()}")
//     println("A quantidade de itens: ${wukongList.count()}")
//     println("suporte está na lista? ${"suporte" in wukongList}")
//     wukongList.add("tank")
//     println(wukongList)
//     wukongList.remove("suporte")
//     println(wukongList)
// }

// -----------------------------------------------

//Set 68

//Lista - organizado e sem duplicatas
//read-only set - setOf() function.
//mutable set - mutableSetOf() function.

// fun main() {
//     val frutas1 = setOf("banana", "cacete")
//     println(frutas1)
    
//     val frutas2: MutableSet<String> = mutableSetOf("cacetinho", "danone")
    
//     // Transformar um mutavel em readonly - casting
//     // val frutas3: MutableList<String> = mutableListOf("cococo", "xixixi")
//     // val frutas4: List<String> = frutas3 //copia da frutas2
    
//     //Nao da para acessar sua ordem
//     //in operator .add() .remove() TUDO IGUAL A LIST
// }

// -----------------------------------------------

//Map - Dicionario 68 - 71

//read-only map - mapOf() function.
//mutable map - mutableMapOf() function.

// fun main() {
//     // Creating an immutable map
//     val menu = mapOf("xixi" to 200, "coco" to 300)
//     println(menu)
    
//     // Creating a mutable map
//     val menu2: MutableMap<String, Int> = mutableMapOf("xixi" to 200, "coco" to 300)
//     println(menu2)
    
//     // Transforming a mutable map into a read-only map - casting
//     val menu3: MutableMap<String, Int> = mutableMapOf("wukong" to 30, "tank" to 300)
//     val menu4: Map<String, Int> = menu3
    
//     //.count() .remove() .keys() .values() in operator
    
//     //.put() 
//     menu4.put("suporte", 10)

//     //.containsKeys()
//     val menu5: MutableMap<String, Int> = mutableMapOf("sett" to 30, "tank" to 300)
//     println("Existe um item sett? ${menu5.containsKey("sett")}")
// }

// -----------------------------------------------
// -----------------------------------------------

//Control Flow 71 - 77

//if, When, For

//if 
// fun main() {
//     val d: Int
//     val check = true
//         if (check) {
//         	d = 1
//         } else {
//         	d = 2
// }
        
//Metodo implicito e rapido 73
// fun main() {
//     val a = 3
//     val b = 4
//     println(if (a > b), a else b)
// }
        
        
// //When
// val description = when {
//     temp < 0 -> "very cold"
//     temp < 10 -> "a bit cold"
//     temp < 20 -> "warm"
//     else -> "hot"
// }
// println(description)

//For
// fun main() {
// 	for (number in 1..5) { //De 1 até 5, é possivel adicionar um step sendo de 2 em 2
//         print(number)
//         }

// //Da para iterar em uma collection
    
// fun main() {

//     val cakes = listOf("carrot", "cheese", "chocolate") //De 1 em 1?
//     for (cake in cakes) {
//     	println("Yummy, it's a $cake cake!")
//     }

//When

//Tipo um if mas com varias opcoes

// fun main (){
//     val x = 10
//     when(x) {
//         10 -> println("vc acertou")
//         "xixi" -> println("vc errou")
//         else -> println("vc errou")
//     }
// }

// //Pode ser usado para varios if + complexos

// fun main() {

//     val tempo = 20
//     val climatempo = when { //Criamos outra variavel para compararmos com o when e poder printar o resulktado dps, se fossemos usar direto no tempo nao daria certo
// p        tempo < 0 -> "Muito frio"
//         tempo > 10 ->"Quentinho"
//         tempo > 30 ->"morte cerebral"
//         else -> "Quente"
//     }
// }

//For

// fun main() {
//     for (number in 1..5) { //1 ate 5 mas podemos tambem step 2 para ir 2 em 2
//     print(number)
//     }

// }

// //Podemos iterar tambem sobre lists ou collections

// fun main() {
//     val cakes = listOf("carrot", "cheese", "chocolate")
//     for (cake in cakes) {
//         println("Yummy, it's a $cake cake!")
//     }
// }

// while

// fun main() {
//     var x = 0
//     while(x < 3){
//         println(x)
//         x++
//     }
// }

// fun main() {
//     var x = 0
//     while (x < 3) {
//         println(x)
//         x++
//     }

//     do {
//         println("So vai parar quando y for maior que x") //Executa pelo menos uma vez aumenta valor do Y toda vez antes de verificar se esta maior que x, util para sang
//         y++
//         while (y > x)
//     }
// }

// -----------------------------------------------
// -----------------------------------------------

//Functions 77 - 83

// fun hello(){
//     println("ai meu cacete")
// }

// fun main() {
//     hello()
// }

//com retorno e passagem de parametros

// fun soma(x: int, y: int): int { // Determinamos o tipo de retorno
//     return x + y
// }

// OU

// fun soma(x: int, y"int) = x + y //Jeito mais rapido sem determinar tipo d eretorno e nem se tem retorno ou nao

// fun main(){
//     val resultado = soma(5,10)
//     print(resultado)

//     //OU

//     print(soma(5,10)) //--> APRENDER ASSIM
// }

//Named Arguments -> passagem de parametros 

// fun printMessageWithPrefix(message = String, prefix: String) {
//     println("[$prefix]" $message)
// }

// fun main(){
//     printMessageWithPrefix("Hello", "Log")
// }

//passagem de parametros com default values

// fun printMessage(message: String, prefix: String = "Muito Safadinho esse") {
//     println("[$prefix] $message")
// }

// fun main() {
//     printMessage("Hello")
//     printMessage("Hello", "Log") //agora mudamos valor de
// }

//Sem retorno

// fun mensagem(){
//     println("Mensagem") //Sem retorno e nem tipo de retorno
// }

// fun main() {
//     mensagem()
// }

// //Com retorno  jeito rapido
// fun soma(x: Int, y: Int) = x + y

// fun main(){
//     print(soma(2,4))
// }

// -----------------------------------------------
// -----------------------------------------------

//Lambda 80 - 83

// fun upprcase(frase: String): String {
//     return frase.toUpperCase()
// }

// fun main() {
//     println(uppercase("Oi tudo bem"))
// }

//em Lambda ficaria assim

// fun main() {
//     println({frase: String -> frase.toUpperCase()}("Oi tudo bem")) //-> lambda faz escrever a funcao oinline na main? 
// }

// //Outro exemplo, passando o retorno da funcao inline para a variavel

// fun main() {
//     val letranova = {frase: String -> frase.toUpperCase()}
//     println(letranova("Oi tudo bem"))

//     //OU

//     val letranova = {it.toUpperCase()} 
//     println(letranova("Oi tudo bem"))
// }

// //Outro exemplo -> ainda mais conciso

// fun main() {
//     val numbers = lisrfOf(1,2,3,4,5)
//     val positives = numbers.filter { x -> x > 0 } //-> FILTER se ujsa com expressoes lambda, devemos sempre declarar a variavel que usaremos no corpo pelo menos uma vez, se nao, usar o it 
//     // val positives = numbers.filter { it > 0 } 
//     println(positives)
// }

// //Definindo uma expressao lambda para uma variavel ( maneira + rapida e curta de escrever funcao )

// //Variavel + funcao que espera como parametro um Grande e retorna uma String
// val palavraGrande: (Grande) -> String = {it.toUpperCase()}//Modo rapido , it = palavra do momento que sera usada como parametro = Grande

// //OU

// val palabraGrande: (Grande) -> String = {Palavra: String -> Palavra.toUpperCase()}//Modo lento, palabra do momento que sera usada como parametro = Grande

// //OUTRO EXEMPLO

// val calcularQuadrado: (Int) -> Int = { numero -> numero * numero } // -> (int) = tipo do parametro

// // Uso:
// val resultado = calcularQuadrado(5) // Resultado será 25


// fun main() {
//     println(palavraGrande("oi tudo bem"))
// }

// //Retornando lambda em uma funcao ( 2 funcoes em uma )

// // ???? po, vou pular agora pqp, depois eu vejo, mas ta ai o  exemplo

// fun main() {
//     //sampleStart
//     // The initial value is zero.
//     // The operation sums the initial value with every item in the list cumulatively.
//     println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6
//     // Alternatively, in the form of a trailing lambda
//     println(listOf(1, 2, 3).fold(0) { x, item -> x + item }) // 6

// -----------------------------------------------
// -----------------------------------------------

//CLass 83 - 88

//Funcoes dentro de classes

// class Contact(val name: String, val age: Int) {
//     fun printIdade() {
//         println("A idade de $name é $age")
//     }
// }

// fun main(){
//     val contact = Contact("Thiago", 20)
//     Contact.printIdade() //-> a funcao eh um atributo da classe Contact
// }

// //Data class -> apenas salvam dados nao executam nada complexo mas existem diversas funcoeszinhas para fazermos com ela como
// //copy, equals, hashcode, toString

// data class Aluno(val RA: String, val nome: String)

// fun main() {
//     usuario1 = Aluno("RA23010116", "Thiago Fossa")
//     usuario2 = Aluno("RA23014234", "Wukong Suporte")

//     print(usuario1)
    
//     // OU

//     //print(usuario1.toString())

//     println("O usuario 1 eh igual ao 2? ${usuario1 == usuario2}")

//     println(usuario1.copy(nome = "Jailson Mendes")) //-> copiamos mas so mudamos o seu valor
// }

// // -----------------------------------------------
// // -----------------------------------------------

// //Null 88 - 90

// /var nome: String = null //-> nao pode ser nulo

//  var nome: String? = null //-> pode ser nulo

//  var nome: String? = "Thiago" //-> pode ser nulo

//  //Elvis Operator

//  val nome: String? = null
//  val nomeNaoNulo = nome ?: "Valor Padrão"

// println(nomeNaoNulo) // Saída: Valor Padrão