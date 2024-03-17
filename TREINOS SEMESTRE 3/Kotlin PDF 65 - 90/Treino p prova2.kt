REVER ARRAYS, INTEGERS NAO ASSINADOS E STRINGS

Basic types
Integer types - TIPOS INTEGER PADROES

PODEM SER NEGATIVOS E POSITIVOS
val one = 1 // Int
val threeBillion = 3000000000 // Long
val oneLong = 1L // Long
val oneByte: Byte = 1

Floating types 
val pi = 3.14 // Double
val e = 2.7182818284 // Double
val eFloat = 2.7182818284f //Termina com f

tamanhos de integer //Podemos usar "_"
Decimals: 123
Longs are tagged by a capital L: 123L
Hexadecimals: 0x0F
Binaries: 0b00001011

val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

Null Types
fun main() {
		val a: Int = 100
		val boxedA: Int? = a
		val anotherBoxedA: Int? = a
		val b: Int = 10000
		val boxedB: Int? = b
		val anotherBoxedB: Int? = b
		println(boxedA === anotherBoxedA) // true
		println(boxedB === anotherBoxedB) // false
}

Conversao de tipos
val a: Int? = 1 
val b: Long? = a
print(b == a) //False pois a possui um tipo diferente de b

//assim que se faz a conversao
fun main() {
		val b: Byte = 1
		// val i: Int = b // ERROR
		val i1: Int = b.toInt()
}

//toByte(): Byte
//toShort(): Short
//toInt(): Int
//toLong(): Long
//toFloat(): Float
//toDouble(): Double

Operacoes de tipos
val l = 1L + 3 // Long + Int => Long

Divisao entre integers
fun main() {
		val x = 5 / 2
		//println(x == 2.5) // ERROR: Operator '==' cannot be applied to 'Int' and 'Double' 
		println(x == 2) //int com int da inteiro e nao quebrado
}

Divisao entre integer e float
fun main() {
		val x = 5 / 2.toDouble() 
		println(x == 2.5) //Yaaay!
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Integer types - TIPOS INTEGER NAO ASSINADOS

SO PODEM SER POSITIVOS E VAO ATE UM POCUO MAIS Q OS ASSINADOS
UByte: an unsigned 8-bit integer, ranges from 0 to 255
UShort: an unsigned 16-bit integer, ranges from 0 to 65535
UInt: an unsigned 32-bit integer, ranges from 0 to 2^32 - 1
ULong: an unsigned 64-bit integer, ranges from 0 to 2^64 - 1

//Se usar tipo nao assinado U, o seu valor deve ter u no final
val b: UByte = 1u 
val s: UShort = 1u 
val l: ULong = 1u 
val a1 = 42u //-> modo curto = UInt
val a2 = 0xFFFF_FFFF_FFFFu 

Funciona para Collections tambem
UByteArray: an array of unsigned bytes
UShortArray: an array of unsigned shorts
UIntArray: an array of unsigned ints
ULongArray: an array of unsigned longs

data class Color(val representation: UInt) //-> UInt pois menor que Long mas maior que Int
val yellow = Color(0xFFCC00CCu) //-> 0xFFCC00CCu (hexadecimal) eh um tipo de numero muito grande para ser um Int e pequeno para ser Long

val byteOrderMarkUtf8 = ubyteArrayOf(0xEFu, 0xBBu, 0xBFu) //Um array de bytes

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Booleans

|| – disjunction (logical OR)
368
&& – conjunction (logical AND)
! – negation (logical NOT)

fun main() {
		val myTrue: Boolean = true
		val myFalse: Boolean = false
		val boolNull: Boolean? = null
		
		println(myTrue || myFalse) //False
		println(myTrue && myFalse) //True
		println(!myTrue) //False
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Characters

fun main() {
		val aChar: Char = 'a'
		println(aChar) //Print somente a letra char
		println('\n') // Prints an extra newline character
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Strings

fun main() {
		val str = "abcd" //Sao strings
		for (c in str) {
		println(c)
		}
}

Strings sao IMUTAVEIS
fun main() {
		val str = "abcd" //VOCE NAO MUDA O ABCD
		println(str.uppercase()) // Create and print a new String object
		println(str) // The original string remains the same
		
		var str = "AVSD" 
println(str) // Saída: AVSD

str = "New Value" // MAS MUDA O STR
println(str) // Saída: New Value
}



Uso de $ e {}
fun main() {
		val i = 10
		println("i = $i") // Prints "i = 10"
}

//Aqui faltou {} para mostrar de fato o lenght da estring por exmeplo
fun main() {
		val s = "abc"
		println("$s.length is ${s.length}") // Prints "abc.length is 3"
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------


Arrays
Arrays sao mutaveris mas nao possuem add() remove() contains()?
Lists tem mais opcoes que arrays em questao de maniuplacao mas ainda sim arrays tem algumas
Para adicionar elemntos ou remover, eh preciso repetidamente criar arrays novos aop invez de simplemente usar list.remove()

Tipos de array
fun main() {
		var riversArray = arrayOf("Nile", "Amazon", "Yangtze") 
		//Ou var riversArray: Array<String> = arrayOf("Nile", "Amazon", "Yangtze")
		riversArray += "Mississippi"
		println(riversArray.joinToString()) //Join to string transofrma em comentariop
		// Nile, Amazon, Yangtze, Mississippi
}

var exampleArray = emptyArray<String>()

Criando um array 
		fun main() {
		val nullArray: Array<Int?> = arrayOfNulls(3)
		println(nullArray.joinToString())
		// null, null, null
}

Definindo tamanho de array
fun main() {
		val initArray = Array<Int>(3) { 0 } //Ao criar um array com tamanho especifico deve-ser usar  Array<3>
		println(initArray.joinToString())
		// 0, 0, 0
}

Nested arrays - Array com array dentro
Funciona com uma expressao lambda 
fun main() 
		val twoDArray = Array(2) { Array<Int>(2) { 0 } }
		println(twoDArray.contentDeepToString())
		// [[0, 0], [0, 0]]
		val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
		println(threeDArray.contentDeepToString())
		// [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
		}
		
array Transforms 
SUM
fun main() {
		//sampleStart
		val sumArray = arrayOf(1, 2, 3)
		// Sums array elements
		println(sumArray.sum())
		// 6
		//sampleEnd
}

Shuffle
fun main() {
		//sampleStart
		val simpleArray = arrayOf(1, 2, 3)
		// Shuffles elements [3, 2, 1]
		simpleArray.shuffle()
		println(simpleArray.joinToString())
		// Shuffles elements again [2, 3, 1]
		simpleArray.shuffle()
		println(simpleArray.joinToString())
		//sampleEnd
		}
		
Transformar em List ou Set
fun main() {
		//sampleStart
		val simpleArray = arrayOf("a", "b", "c", "c")
		// Converts to a Set
		println(simpleArray.toSet())
		// [a, b, c]
		// Converts to a List
		println(simpleArray.toList())
		// [a, b, c, c]
		//sampleEnd
}

Transformar em Map
SOMENTE SE O ARRAY FOR MONTADO COMO UQE FOSSE UM MAP/DICIONARIO
fun main() {
		//sampleStart
		val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
		// Converts to a Map
		// The keys are fruits and the values are their number of calories
		// Note how keys must be unique, so the latest value of "apple"
		// overwrites the first
		println(pairArray.toMap())
		// {apple=140, banana=150, cherry=90}
		//sampleEnd
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Checks and Casts
Verificar ou dar um tipo dinamicamente para uma variavel

if (obj is String) {
		print(obj.length)
}

if (obj !is String) { // Same as !(obj is String)
	print("Not a String")
} else {
	print(obj.length)
}

Smart Cast
fun demo(x: Any) {
	if (x is String) { //x agora eh um String e sera tratado como um
print(x.length) 
	}
}

if (x is String && x.length > 0) {
print(x.length) // x is automatically cast to String
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Conditional Expressions
If, When - Ja vi, iguais de sempre
For - Ja vi tambem mas so alguns remembers
While - Ja vi tambem mas so alguns remembers

For
Range - de 1 ate 3 mas pode ser tambem de 1 ate n
Pode conter step e downTo
fun main() 
		for (i in 1..3) { 
				println(i)
		}
		for (i in 6 downTo 0 step 2) {
				println(i)
		}
		
Para navegar pelo ARRAY ou LISTA so pelo INDEX e nao p[elo seus items
fun main() {
		val array = arrayOf("a", "b", "c")
			for (i in array.indices) {
				println(array[i])
				}
}

While e Do-While
Returns and jumps

Break and continue labels
loop@ for (i in 1..100) {
	for (j in 1..100) {
		if (...) break@loop //Para usar Break em um loop, tem q ser um Continue Labekl e por um @ no fim da declarao
		}
}	

Return to labels
fun foo() {
	listOf(1, 2, 3, 4, 5).forEach {
		if (it == 3) return //Ao chegar no 3 a funcao inteira eh interrompida
			print(it)
}
	println("this point is unreachable")
}
	//sampleEnd
fun main() {
	foo()
}
	
//----------------------------------------------------------------------
//----------------------------------------------------------------------

Exceptions

fun main() {
    try {
        throw Exception("Hi There!") //Criamos uma excecao, um erro
    } catch (e: Exception) { //Se der esse erro
        println("Exceção capturada: ${e.message}") //Print message
    } finally { //Finalmmente, independentemente do que aconteca
        println("Este bloco sempre será executado.") //Print message
    }
}

fun getNumberFromUser(): Int {
	println("Por favor, insitra um numero: ")
	val userINput = reaadLine()
	return userINput!!.toInt()
}

fun main() {
	try{
		val number = getNumberFromUser()
	} catch (e: NumberFormatException) {
		println("Isso nao eh um numero valido")
	} finally {
		println("Obrigado por usar o programa")
	}
}

//----------------------------------------------------------------------
//----------------------------------------------------------------------

Packages and imports

Imports = biblioteca de funcoes + funcoes de outros modulos -> pode ser especificado para o que vc quer importar:
import org.example.Message // Message is now accessible without qualification
import org.example.* // everything in 'org.example' becomes accessible

Classes
class MinhaClasse //Classe sem atributos e sem corpo somente com cabecalho
class MinhaClasse<T>(atributo: T) //Classe com atributos em um construtor primario e sem corpo -> T eh tipo generico
class MinhaClasse<t>(atributo2: t) { //Classe com atributos em um construtor primario e com corpo -> t eh tipo generico
    fun minhaFuncao() {
        println("Olá do método minhaFuncao!")
    }
}

Construtor primario
exemplos: 
class MinhaClasse(val atributo: Int) 

class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true)

class Person(
val firstName: String,
val lastName: String,
var age: Int, // trailing comma
) { /*...*/ }

class InitOrderDemo(name: String) {
	val firstProperty = "First property: $name".also(::println)
}

class ClasseComFUncao(val atributo: Int) {
	fun minhaFuncao() {
		println("Olá do método minhaFuncao!")
	}
}

Construtor secundario
iniciados com o metodo constructor(atributo: Tipo) 
exemplos:

class Pessoa(val nome: String, val idade: Int) {
	fun printmensasage(){
		println("Ola, meu nome eh $nome e tenho $idade anos")
	}

	constructor(nome: String) : this(nome, 0) 
    
    fun printmensasage2(){
			println("Ola, meu nome eh $nome e sem idade especificada")// A declaracao funcao deve ficar fora do conmstrutro secundario para funcionar corretamente
		}
}

fun main(){
	val p1 = Pessoa("Lucas", 25)
	val p2 = Pessoa("Pedro")
    p1.printmensasage()
    p2.printmensasage2()
}

Class Inheritance - Classe e subclasse - Orientacao objeto?
exemplos:

open class Animal(val especie: String) { //Classe pai, OPEN = aberta para ser herdada
	open fun fazerSom() {
		println("O animal esta fazendo um som")
	}
}

class Cachorro(val nome: String) : Animal(nome) { //Classe filha, o tipo da classe filha eh a classe pai entrando como atributo/parametro nome
	override fun fazerSom() { //Override = sobrescrever a funcao do pai
		println("O cachorro late: Woof! Woof!")
	}

	fun abanarRabo() {
        println("O cachorro está abanando o rabo")
    }
}

fun main(){
	val animal = Animal("doguinho")
	val yorkshire = Cachorro("Robertinho")

	animal.fazerSom()
	yorkshire.fazerSom()
	yorkshire.abanarRabo()
}

Overriding methods
open class Shape {
	open val vertexCount: Int = 0
	}

	class Rectangle : Shape() {
	override val vertexCount = 4
	}

OU

open class Shape(open val vertexCount: Int = 0)
class Rectangle(override val vertexCount: Int = 4) : Shape()