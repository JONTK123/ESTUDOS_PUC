//EXERICIO PRATICO GUIADO -> PRESTAR ATENÇÃO ENUNCIADO PRINCIPALMENTE EX 13, 
data class Veiculo(
    val fabricante: String,
    val modelo: String,
    val anoFabricação: Int
    val anoModelo: Int,
    val km: Double = 0.0
)

data class Empresa(
    val razaoSocial: String,
    val nomeFantasia: String,
    val CNPJ: String
)

data class Locacao(
    val dataRetirada: String,
    val dataDevolução: String,
    val e: Empresa,
    val v: Veiculo
) {
    fun imprimir(){
        println("Retirada: $dataRetirada - Devolução: $dataDevolucao - Empresa: ${e.nomeFantasia} - Veículo: ${v.modelo}")
    }
}

fun main(){
    val v1 = Veiculo("Fiat", "Mobi", 2024, 2024)
    val v2 = Veiculo("Volkswagen",
                    "Polo",
                    2022,
                    2023,
                    11312.8)
    
    val puc = Empresa("Sociedade Campineira de Educação",
                    "PUC-CAMPINAS",
                    "00.111.222/0001-10")

    val 11 = Locacao("08/03/2024 - 10:00:00", "", puc,v1)
    11.imprimir() //INSTANCIA.ATRIBUTO DA CLASSE para acessar a função

    val 12 = Locacao("08/03/2024 - 10:00:00","", puc, v2)

    // val listaLocacoes = mutableListOf()
    // ou
    // val listaLocacoes: MutableList<Locacao> = mutableListOf()
    // listaLocacoes.add(11,12)
    
    Gerenciador = GerenciadorLocacoes(listaLocacoes)
    Gerenciador.adicionar(11)
    Gerenciador.adicionar(12)

    Gerenciador.imprimirLocs()
    println(Gerenciador.buscapCNPJ("00.111.222/0001-10"))
}

//EX 10
//Construtor primario eh o que vem logo em seguida das () na criação da classe
class GerenciadorLocacoes (val listaLoc: MutableList<Locacao> = mutableListOf()){

//EX 11
    fun imprimirLocs() {
        println("Locações: $listaLoc")
    }

//EX 12
    fun adicionar(loc: Locacao){
        listaLoc.add(loc)}

//EX 13
        //Só quero o CNPJ, se eu colocar como parametro :Empresa, preciso por a instancia puc inteira
        //Ademais, o retorno deve ser TODAS as locações do CNPJ informado, logo retorno eh uma LISTA do tipo LOCACAO
        // fun buscapCNPJ(emp: Empresa): Locacao { 
        //     if emp.CNPJ == listaLoc.e.CNPJ
        //         return listaLoc
        //     else
        //         return 
        // }

    fun buscapCNPJ(CNPJ: String):list<Locacao> { //USuario vai digitar o CNPJ e nao o nome da empresa
        val listaCNPJ: MutableList<Locacao> = mutableListOf() //Como o retorno eh uma lista, temos que criar uma lista com os CNPJ
        //ListaLoc é uma lista de locacoes porntato um for para percorrer cada uma ela e achar o cnpj digitado 
        if CNPJ == i.e.CNPJ
        for (i in listaLoc){ //i = Locacao atual da lista
            if CNPJ == i.e.CNPJ //Se o CNPJ digitado = ao presente na lista ->
                listaCNPJ.add(CNPJ) //Add na lista de CNPJ
        }
            return listaCNPJ //Return fora do for para ele averiguar todos os itens presentes na lsitaLoc
    }
}

// ---------------------------------------------------------------------
// ---------------------------------------------------------------------

fun main(){
    val v1 = Veiculo("Fiat", "Mobi", 2024, 2024)
    val v2 = Veiculo("Volkswagen",
                    "Polo",
                    2022,
                    2023,
                    11312.8)
    
    val puc = Empresa("Sociedade Campineira de Educação",
                    "PUC-CAMPINAS",
                    "00.111.222/0001-10")

    val 11 = Locacao("08/03/2024 - 10:00:00", "", puc,v1)
    11.imprimir() 

    val 12 = Locacao("08/03/2024 - 10:00:00","", puc, v2)

    val listaLocacoes = mutableListOf()
    listaLocacoes.add(11)
    listaLocacoes.add(12)

    Gerenciador = GerenciadorLocacoes()
    Gerenciador.imprimirLocs(listaLocacoes)
    println(Gerenciador.buscapCNPJ(listaLocacoes, "00.111.222/0001-10"))
}

class GerenciadorLocacoes (){
    fun imprimirLocs(lista: MutableList<Locacao>) {
        println("Locações: $lista")
    }
    
    fun buscapCNPJ(CNPJ: String):list<Locacao> { 
        val listaCNPJ: MutableList<Locacao> = mutableListOf() 
        for (i in listaLoc){
            if CNPJ == i.e.CNPJ 
                listaCNPJ.add(CNPJ) 
        }
            return listaCNPJ 
    }

}