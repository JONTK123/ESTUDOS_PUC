package br.edu.puccampinas.bestbuylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        // Ajustando as dimensões do constraint (Edge to Edge) para versões do Android a partir da 19.
        adjustLayoutConstraint()

        // Inicializando o banco de dados
        db = AppDatabase.getInstance(applicationContext)

        // Configurando o botão de salvar
        binding.btnSave.setOnClickListener {
            val description = binding.etDescription.text.toString().trim()
            if (description.isNotEmpty()) {
                // Inserir o novo item no banco de dados
                val newItem = Item(id = null, description = description, checked = false)
                insertNewItem(newItem)
            }
        }
    }

    private fun adjustLayoutConstraint() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupViewBinding() {
        binding = ActivityAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun insertNewItem(item: Item) {
        CoroutineScope(Dispatchers.IO).launch {
            db.itemDao().insert(item)
            // Após a inserção, voltar para a activity anterior
            finish()
        }
    }
}