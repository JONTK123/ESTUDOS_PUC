package br.edu.puccampinas.bestbuylist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.puccampinas.bestbuylist.databinding.ActivityBuyListBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuyListActivity : AppCompatActivity(), OnDeleteItem {

    private lateinit var binding: ActivityBuyListBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup do layout
        setupViewBinding()

        // Ajustando as dimensões do constraint (Edge to Edge) para versões do Android a partir da 19.
        adjustLayoutConstraint()

        // Preparando a RecyclerView
        prepareRecyclerView()

        // Inicializando o banco de dados
        db = AppDatabase.getInstance(applicationContext)

        // Carregando a lista de itens
        loadBuyList()

        // Inserindo dados estáticos no banco (opcional, caso o banco esteja vazio)
        insertData()
    }

    private fun adjustLayoutConstraint() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupViewBinding() {
        binding = ActivityBuyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun prepareRecyclerView() {
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.setHasFixedSize(true)
    }

    private fun loadBuyList() {
        // Puxar os itens do banco de dados e mandar para a lista
        CoroutineScope(Dispatchers.Main).launch {
            val items = withContext(Dispatchers.IO) {
                db.itemDao().getAll()
            }
            // Criar um adaptador e mapear esse adaptador para a lista
            val itemsAdapter = AdapterListItem(ArrayList(items), this@BuyListActivity)
            binding.rvItems.adapter = itemsAdapter
        }
    }

    private fun insertData() {
        // Inserir dados estáticos no banco de dados (caso esteja vazio)
        CoroutineScope(Dispatchers.IO).launch {
            val i1 = Item(1, "Detergente", false)
            val i2 = Item(2, "Sabão em pó", false)
            val i3 = Item(3, "Picanha", false)
            val i4 = Item(4, "Abóbora", false)
            db.itemDao().insertAll(i1, i2, i3, i4)
        }
    }

    override fun delete(item: Item) {
        // Apagar o elemento da lista (fazer a implementação)
        Snackbar.make(binding.root, "Implementar... ", Snackbar.LENGTH_LONG).show()
    }
}
