//Lambda
//1

// fun main() {
//     println({frase:string -> frase.toUpperCase()}("Ola mundo!"))
// }

// //2

// fun main() {
//     val LetraGrande = {frase:String -> frase.toUpperCase()}
//     val resuktad = LetraGrande("sexinho")
// }

// fun main() {
//     val lista = listOf{1,2,3,4,5}
//     val calcularDobro = lista.filter{{n -> n * 2}}
//     println(calcularDobro)
// }

// fun main() {
//     val listaNumeros = listOf(1,2,3,4,5)
//     val FiltraPositivos = listaNumeros.filter(n -> n >0)
//     println(FiltraPositivos)
// }

// //3

// fun main() {
//     val actions = listOf("title", "year", "author")
//     val prefix = "https://example.com/book-info"
//     val id = 5
//     val urls = actions.map{action -> "$prefix/$action/$id"} //Transformo valor de uma variavel para uma string inteira
//     println(urls)
//     }

// //4

// fun CalculaQuadrado(n: Int): (Int) -> Int = {n -> n * n}

// fun main() {
//     val numero = CalculaQuadrado(5) //numero acaba se transformando em uma funcao, serve como base
//     val resultado = numero(10) //Mas de fato o ccalculo ocorrera com o numero 10
//     println(numero)
// }

// //DIFERENCA QUE UM RETORNA DIRETAMENTE O RESULTADO E OUTRA RETORNA UMA FUNCAO PARA REALIZAR O RESULTADO

// fun CalculaQuadrado(n: int): int{
//     return n*n 
// }

// fun main() {
//     val numeroQuadrado = CalculaQuadrado(5)
//     println(numeroQuadrado)
    
// }

// // 5

// //Sem parametros e sem retorno
// fun repeatN(n: Int, action: () -> Unit) {
//     for (i in 1..n) {
//         action()
//     }
// }

// fun main() {
//     repeatN(5) {
//         println("Hello") //Isso na verdade se torna a funcao action pois nao tem parametros de entrada e nem retorno especifico
//     }
// }

// //Com parametros e com retorno
// fun repeatN(n: Int, action: (Int) -> Int) {
//     for (i in 1..n) {
//         val result = action(i)
//         println("Result of action($i): $result")
//     }
// }

// fun main() {
//     repeatN(5) { num ->
//         num * num
//     }
// }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

