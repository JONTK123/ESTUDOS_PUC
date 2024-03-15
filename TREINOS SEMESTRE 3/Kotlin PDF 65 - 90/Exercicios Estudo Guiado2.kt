// Crie a classe Produto com os seguintes atributos: nome, categoria, preço e quantidade.

// Abaixo do código da classe Produto, crie a classe Fornecedor com os seguintes atributos: nome, endereço e telefone.

// Abaixo do código da classe Fornecedor, crie a classe Pedido com os seguintes atributos: número, data do pedido, fornecedor e uma lista de produtos.

// Modifique (caso exista) ou acrescente a função main do programa em Kotlin para que ela crie instâncias de Produto, Fornecedor e Pedido, e as utilize de acordo com as instruções fornecidas.

// Leia o código da função main da questão anterior e complete uma tabela fornecida, informando os nomes das instâncias e de quais classes são.

// Na classe Pedido, acrescente um método chamado imprimir(), que imprime informações sobre o pedido e seus produtos.

// Na função main, invoque o método imprimir() em uma instância de Pedido.

// Na função main, crie uma instância imutável chamada pedidos, do tipo MutableList<Pedido>, e inicialize-a com uma lista vazia.

// Na função main, adicione o pedido criado à lista de pedidos.

// Crie uma classe chamada GerenciadorPedidos, com um construtor primário recebendo uma lista de pedidos.

// Na classe GerenciadorPedidos, acrescente um método chamado imprimir, que imprime todos os pedidos da lista.

// Na classe GerenciadorPedidos, acrescente um método chamado adicionar, que adiciona um pedido à lista de pedidos.

// Na classe GerenciadorPedidos, acrescente um método chamado buscarPorFornecedor, que retorna uma lista de pedidos de um fornecedor específico.

data class Produto(val nome: String, val categoria: String, val preco: Double, val qntd: Int)
data class Fornecedor(val nome: String, val endereco: String, val telefone: String)

class Pedido(val numero: Int, val date: String, val fornecedor: Fornecedor, val listaProduto: MutableList<Produto> = mutableListOf()) { //Ou val listaProduto = mutableListOf<String>()()
				 
    			fun imprimir(){
                     val listaProdutoNome = mutableListOf<String>() //Como a lista esta vazia, eh necessario especificar o tipo dela, mas se estiver com algo, nao eh necessario
                     for (produto in listaProduto){
                         listaProdutoNome.add(produto.nome) //i nesse caso eh um tipo Produto entao para acessar seu nome eh i.nome
                     }
                     println("Aqui esta a lista de produtos do pedido: $numero $date ${fornecedor.nome} $listaProdutoNome.")
                 }
} 

class GerenciadorPedido(val listaPedido: MutableList<Pedido> = mutableListOf()){
    
						fun imprimir(){
                            for (pedido in listaPedido){
                            	println("Aqui estao todas as informacoes de pedidos: ${pedido.numero} ${pedido.date} ${pedido.fornecedor.nome}")
                                for (produto in pedido.listaProduto){ //listaProduto esta dentro de listaPedido, e como eh uma lista dentro de lista = outro for
                                	println("Aqui esta a lista de produtos: ${produto.nome}")
                                }
                            }	
                        }
                        
                        fun adicionar(ped: Pedido): MutableList<Pedido>{
                           listaPedido.add(ped)
                           return listaPedido
                        }
                        
                        fun buscarPorFornecedor(fornecedor: String): MutableList<Pedido>{ //Retornar uma lista = somente por List ou MutableList, NAO PRECISA PARAMETRO DA LISTA POIS ESTA DENTRO DA MESMA CLASSE
                            val pedidoListFornecedor = mutableListOf<Pedido>()
                            for (pedido in listaPedido){
                                if(fornecedor == pedido.fornecedor.nome){ //Se o fornecedor digitado = fornecedor do pedido
                                    pedidoListFornecedor.add(pedido) //Add o pedido iterado para a lista de pedido que corresponde a igualdade
                                }
                            }
                            
                        for(pedido in pedidoListFornecedor){ //percorrer novamente, mas desta vez a lsita de fornecedores, pois ainda sim eh uma lista de pedidos ( c/ varios atributos )
							println(pedido.fornecedor.nome) //Acessa o atributo exato que contem o nome do fornecedor ao envez de tentar imprimir a lista toda.
                        }
                        
                        return pedidoListFornecedor
                            
                        }
					}

fun main() {
	val p1 = Produto("Desodorante", "Higiene", 20.30, 5)
    val p2 = Produto("Ibuprofeno", "Remedios", 5.32, 20)
    val p3 = Produto("Corretivo", "Maquiagem", 32.32, 1)

    
    val f1 = Fornecedor("SeuZe", "Av.Kennedy 234", "(19)950266683")
    val f2 = Fornecedor("DonaZe", "Av.Conceicao 242", "(19)999338806")
    
    val ped1 = Pedido(1, "13/03/2024", f1, mutableListOf(p1,p2)) //Criando estancia com atributo de classe sendo uma lista
	val ped2 = Pedido(2, "12/03/2024", f2, mutableListOf(p1,p3))
    
    ped1.imprimir()
    
    val Gerenciador = GerenciadorPedido()//Inicializei vazio
    Gerenciador.adicionar(ped1)
    Gerenciador.adicionar(ped2)
    
    Gerenciador.imprimir()
    Gerenciador.buscarPorFornecedor("SeuZe")
	
}