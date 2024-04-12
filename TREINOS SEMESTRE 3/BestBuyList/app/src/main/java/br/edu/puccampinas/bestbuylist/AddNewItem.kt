package br.edu.puccampinas.bestbuylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.puccampinas.bestbuylist.databinding.ActivityAddNewItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewItemBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup do layout
        setupViewBinding()

        // Inicializando o banco de dados
        db = AppDatabase.getInstance(applicationContext)

        // Configurando o botão de salvar
        binding.btnSave.setOnClickListener {
            val description = binding.etNewItem.text.toString()
            val newItem = Item(0, description, false)
            insertItem(newItem)
        }
    }

    private fun setupViewBinding() {
        binding = ActivityAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun insertItem(item: Item) {
        CoroutineScope(Dispatchers.IO).launch {
            db.itemDao().insert(item)
            finish() 
        }
    }
}
