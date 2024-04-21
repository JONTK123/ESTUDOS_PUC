package br.edu.puccampinas.requests

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.puccampinas.requests.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // onClick do botão para testar Async para obter todos os itens.
        binding.btnGetAllItems.setOnClickListener {
            TaskRequestAllItems().execute()
        }

        // onClick do botão para adicionar um novo item.
        binding.btnAddNewItem.setOnClickListener {
            val newItem = Item("Nome do Novo Item", "Descrição do Novo Item")
            TaskAddNewItem().execute(newItem)
        }
    }

    private fun showResultsAsyncTask(result: List<Item?>?){
        val gson = Gson()
        binding.tvResultado.text = gson.toJson(result)
    }

    inner class TaskRequestAllItems: AsyncTask<Void, Void, List<Item?>>() {

        override fun doInBackground(vararg params: Void?): List<Item?> {
            val api = ItemsApi()
            return api.getAllItems()
        }

        override fun onPostExecute(result: List<Item?>?) {
            super.onPostExecute(result)
            // Aqui sim podemos interagir com a Thread de UI pois não está mais bloqueada.
            showResultsAsyncTask(result)
        }

    }

    inner class TaskAddNewItem : AsyncTask<Item, Void, String>() {

        override fun doInBackground(vararg params: Item): String {
            val api = ItemsApi()
            return api.addNewItem(params[0])
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            showResultsAsyncTask(result)

            }
        }
    }
}

//USANDO COROUTINES
// import android.os.Bundle
// import androidx.appcompat.app.AppCompatActivity
// import br.edu.puccampinas.requests.ItemsApi
// import br.edu.puccampinas.requests.databinding.ActivityMainBinding
// import com.google.gson.Gson
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.GlobalScope
// import kotlinx.coroutines.launch
// import kotlinx.coroutines.withContext

// class MainActivity : AppCompatActivity() {

//     private lateinit var binding: ActivityMainBinding
//     private val itemsApi = ItemsApi()
//     private val gson = Gson()

//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)

//         binding = ActivityMainBinding.inflate(layoutInflater)
//         setContentView(binding.root)

//         // onClick do botão para testar Coroutines para obter todos os itens.
//         binding.btnGetAllItems.setOnClickListener {
//             getAllItemsWithCoroutines()
//         }

//         // onClick do botão para adicionar um novo item.
//         binding.btnAddNewItem.setOnClickListener {
//             val newItem = Item("Nome do Novo Item", "Descrição do Novo Item")
//             addNewItemWithCoroutines(newItem)
//         }
//     }

//     private fun showResults(items: List<Item?>?) {
//         binding.tvResultado.text = gson.toJson(items)
//     }

//     private fun getAllItemsWithCoroutines() {
//         GlobalScope.launch(Dispatchers.Main) {
//             val items = withContext(Dispatchers.IO) {
//                 itemsApi.getAllItems()
//             }
//             showResults(items)
//         }
//     }

//     private fun addNewItemWithCoroutines(item: Item) {
//         GlobalScope.launch(Dispatchers.Main) {
//             val result = withContext(Dispatchers.IO) {
//                 itemsApi.addNewItem(item)
//             }
//             // Você pode adicionar aqui qualquer tratamento do resultado, se necessário
//         }
//     }
// }