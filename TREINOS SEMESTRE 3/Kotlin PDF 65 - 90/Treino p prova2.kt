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

