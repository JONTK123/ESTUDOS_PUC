package com.example.estudosprova2 // Pacote onde todos os arquivos estarão vinculados, como outras atividades.

import android.os.Bundle // O "Bundle" é um objeto que contém dados passados entre componentes da atividade.
import androidx.appcompat.app.AppCompatActivity // "AppCompatActivity" é uma classe base para atividades, fornecendo funcionalidades comuns.
import com.example.estudosprova2.databinding.ActivityMainBinding // Import da classe binding com o nome da activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

// Imports de classes e funções de RecyclerView
import androidx.recyclerview.widget.LinearLayouManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//CICLO DE VIDA DE UMA ACTIVITY

//savedInstanceState - Restaurar dados que foram destruidos - Rotacao de tela, fechamento atividade, transitaqr para segundo plano... Eh do tipo Bundle
//Bundle - Estrutura de dados do Android para armazenar dados como Int, String etc, Eles salvam os dados que precisam ser preservadors
//AppCompatActivity - Possui diversas atividades como Oncreate etc etc etc...

class MainActivity : AppCompatActivity() { // Classe principal da atividade, derivada de AppCompatActivity.

    private lateinit var binding: ActivityMainBinding // Nome do Binding vai mudar de acordo com o nome da activity
    private lateinit var auth: FirebaseAuth // Autenticacao do Firebase, vai carregar as funções de autenticação
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var user: String
    private lateinit var userID: String
    private lateinit var db: FirebaseFirestore // Firestore eh um banco de dados, vai carregar funções de manipulação de dados

    private lateinit var recyclerView: RecyclerView
    private lateinit var NumeroAdapter: NumeroAdapter

        inner class NumeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // Cria a ViewHolder
            private val textViewNumero: TextView = itemView.findViewById(R.id.textViewItem)
    
            fun bind(numero: String) {
                textViewNumero.text = numero
    
                // Adiciona um listener de clique ao item da lista
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Clicou no número: $numero", Toast.LENGTH_SHORT).show()
                }
            }
        }

    inner class NumeroAdapter : RecyclerView.Adapter<NumeroViewHolder>() { // Definindo um adaptador para manipular dados da recycler view

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumeroViewHolder { // Cria a ViewHolder
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false) // Infla cada item do ViewHolder com o layout do item_list.xml
            return NumeroViewHolder(view)
        }

        override fun onBindViewHolder(holder: NumeroViewHolder, position: Int) { // Associamos posições para os dados da ViewHolder????
            val numero = (position + 1).toString() // Números de 1 a 100
            holder.bind(numero)
        }

        override fun getItemCount(): Int {
            return 100 // Número total de itens na lista
        }
    }
}

    override fun onCreate(savedInstanceState: Bundle?) { // Sobreescreve a funcao Oncreate quando a atividade está sendo criada. "savedInstanceState" é usado para restaurar o estado da atividade.
        super.onCreate(savedInstanceState) // Chama a implementação da classe pai (Original) para garantir que a inicialização básica seja realizada.

        recyclerView = findViewById(R.id.recyclerView) // Referencia o RecyclerView do layout
        recyclerView.layoutManager = LinearLayoutManager(this) // Define o layout do RecyclerView
        recyclerView.adapter = NumeroAdapter() // Define o adaptador do RecyclerView

        binding = ActivityMainBinding.inflate(layoutInflater) // Inicializando o binding, deve ficar dentro de um metodo e apenas dentro de um, geralmente no oncreate mesmo
        auth = FirebaseAuth.getInstance()

        //setContentView(binding.root)(R.layout.activity_main) // Define o layout da atividade, ou seja, como a interface do usuário será apresentada.
        setContentView(binding.root) // Define o layout da atividade. Nesse caso sera atraves de bindingview

        //OnCreate - Atividade de inicializacao, inflar layout de interface, inicializar variaveis, INICIALIZACAO...
                    // Nao eh uma boa ideia todo o codigo estar aqui dentro

        binding.textView.text = "Hello, ViewBinding!" //Acessando a View pelo viewbinding. View deve ter ID com nome da sua View. Sobreescrevemos o android:text do xml

        // Simulando dados para a RecyclerView
        val numeros = mutableListOf<String>()
        for (i in 1..100) {
            numeros.add("Número $i")
        }

        recyclerView.adapter = NumeroAdapter(numeros) // Define o adaptador do RecyclerView

    }

    override fun onStart() {
        super.onStart()
        //OnStart - A atividade que carrega antes da atividade principal se tornar visivel.
                //Exemplo P.i -> Por exemplo, o usuario ja estava logado no app antes de sair. Ao retornar ->
                // o OnStart ira carregar primeiro q a funcao principal para verificar se o usuario ja estava logado

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registro bem-sucedido
                    val user = FirebaseAuth.getInstance().currentUser
                    // Faça algo com o usuário registrado, se necessário
                } else {
                    // Falha no registro
                    val exception = task.exception
                    // Lidar com a exceção, se necessário
                }
            }
            .addOnFailureListener { exception ->
                // Lidar com a falha na criação do usuário
            }

            db = FirebaseFirestore.getInstance()

            user = auth.currentUser
            userID = user.uid

            val usuario = hasMapOf (
                "email" to email,
                "password" to password,
                "ID" to userID
            )

            db.collection("users").document(userID)
                .add(usuario)

                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                
                .onFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

        }

    override fun onResume() {
        super.onResume()
        //OnResume - A atividade está em primeiro plano e pronta para interações do usuário
                //Toda vez q eu retornar para essa atividade, ele ira Retomar algo. Seja demonstrar informacoes de login do usuario autenticado
                //Exemplo P.I -> Quando o usuario retornar, ele retoma as variaveis que foram salvas no OnPause para retomar o uso do app
    }

    override fun onPause() {
        super.onPause()
        //OnPause - Ao interromper a atividade principal, pausa alguma outra atividade
                //Exemplo, se vc estava tocando uma musica e perdeu o foco por conta de uma ligacao. A musica deve pausar
                //Exemplo P.I -> Se usuario estava registrando no app e alguem o ligou ou tela do celular desligou. Ele salva as informacoes q estava escrevendo para as caixas de texto
    }

    override fun onStop() {
        super.onStop()
        //OnStop - Quando a atividade ja nao estiver mais visivel para o usuario, voce as "desliga"
                //Exemplo P.I -> Ao sair do app, ape de register, a funcao onStop ira terminar a conexao do Firestore.
    }

    override fun onDestroy() {
        super.onDestroy()
        //onDestroy - A atividade está sendo destruída, finalizada por completo
                //Exemplo P.I -> Acabou a bateria do usuario ao estar se registrando, Finish(), similar ao onStop
    }
}


