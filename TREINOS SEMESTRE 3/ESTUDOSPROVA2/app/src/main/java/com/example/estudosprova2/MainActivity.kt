package com.example.estudosprova2 // Pacote onde todos os arquivos estarão vinculados, como outras atividades.

import android.os.Bundle // O "Bundle" é um objeto que contém dados passados entre componentes da atividade.
import androidx.appcompat.app.AppCompatActivity // "AppCompatActivity" é uma classe base para atividades, fornecendo funcionalidades comuns.
import com.example.estudosprova2.databinding.ActivityMainBinding // Import da classe binding com o nome da activity
import com.google.firebase.auth.FirebaseAuth


//CICLO DE VIDA DE UMA ACTIVITY

//savedInstanceState - Restaurar dados que foram destruidos - Rotacao de tela, fechamento atividade, transitaqr para segundo plano... Eh do tipo Bundle
//Bundle - Estrutura de dados do Android para armazenar dados como Int, String etc, Eles salvam os dados que precisam ser preservadors
//AppCompatActivity - Possui diversas atividades como Oncreate etc etc etc...

class MainActivity : AppCompatActivity() { // Classe principal da atividade, derivada de AppCompatActivity.

    private lateinit var binding: ActivityMainBinding // Nome do Binding vai mudar de acordo com o nome da activity
    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var user: String



    override fun onCreate(savedInstanceState: Bundle?) { // Sobreescreve a funcao Oncreate quando a atividade está sendo criada. "savedInstanceState" é usado para restaurar o estado da atividade.
        super.onCreate(savedInstanceState) // Chama a implementação da classe pai (Original) para garantir que a inicialização básica seja realizada.

        binding = ActivityMainBinding.inflate(layoutInflater) // Inicializando o binding, deve ficar dentro de um metodo e apenas dentro de um, geralmente no oncreate mesmo
        auth = FirebaseAuth.getInstance()

        //setContentView(binding.root)(R.layout.activity_main) // Define o layout da atividade, ou seja, como a interface do usuário será apresentada.
        setContentView(binding.root) // Define o layout da atividade. Nesse caso sera atraves de bindingview

        //OnCreate - Atividade de inicializacao, inflar layout de interface, inicializar variaveis, INICIALIZACAO...
                    // Nao eh uma boa ideia todo o codigo estar aqui dentro

        binding.textView.text = "Hello, ViewBinding!" //Acessando a View pelo viewbinding. View deve ter ID com nome da sua View. Sobreescrevemos o android:text do xml

    }

    override fun onStart() {
        super.onStart()
        //OnStart - A atividade que carrega antes da atividade principal se tornar visivel.
                //Exemplo P.i -> Por exemplo, o usuario ja estava logado no app antes de sair. Ao retornar ->
                // o OnStart ira carregar primeiro q a funcao principal para verificar se o usuario ja estava logado

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
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


