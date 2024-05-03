package com.example.mynewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.nfc.NdefMessage
import android.nfc.NfcAdapter

class MainActivity : AppCompatActivity() {

    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this) //Referencia o adaptador NFC do dispositivo

        override fun onNewIntent(intent: Intent) { //FUNÇÃO PARA QUANDO IDENTIFICAR INTENT, PROCESSA-LO
            super.onNewIntent(intent)
            ...
            if (NfcAdapter.ACTION_TAG_DISCOVERED == intent.action) { //Verifica se o intent ( a criada automaticamente ) do NFC é do tipo descoberta de tag
                intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages -> //Pega o dado do intent descoberto e transforma em um array de mensagens NDEF que o AdapatadorNFC entende -> Verifica se os dados é vazio e transforma em array de mensagens NDEF
                    val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage } //Transforma cada mensagem do array em uma mensagem NDEF

                    //APÓS ISSO, LÓGICA PARA O QUE FAZER COM ESSAS MENSAGENS -> TAG contem a chave do armario, Leu -> então desbloqueia armario. 
                    ...

                    
                }
            }
        }
    }
}


package com.example.mynewapp

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.Ndef
import android.nfc.tech.NdefFormatable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this) // Referencia o adaptador NFC do dispositivo
    }

    override fun onNewIntent(intent: Intent) { // Função chamada quando uma nova intent é recebida
        super.onNewIntent(intent)
        if (NfcAdapter.ACTION_TAG_DISCOVERED == intent.action) { // Verifica se o intent é para descoberta de tag NFC
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages -> 
                // Extrai as mensagens NDEF da intent
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage } 
                // Converte as mensagens para uma lista de objetos NdefMessage

                // Lógica para processar as mensagens NDEF
                // Exemplo: TAG contém a chave do armário, ao ler desbloqueia o armário
            }

            // Criação dos novos dados a serem gravados na tag
            val newData = "Novos dados a serem gravados na tag" 
            // Define os dados a serem gravados como texto
            val newNdefMessage = NdefMessage(arrayOf(NdefRecord.createTextRecord(null, newData))) 
            // Cria uma nova mensagem NDEF com os dados definidos

            // Obtém a tag NFC da intent
            val tag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG) 

            // Chama a função para escrever os dados na tag NFC
            writeNdefMessage(tag, newNdefMessage) 
        }
    }

    private fun writeNdefMessage(tag: Tag, message: NdefMessage) {
        // Função para escrever a mensagem NDEF na tag NFC
        val ndef = Ndef.get(tag)
        // Obtém o objeto Ndef para a tag NFC
        ndef?.let {
            ndef.connect()
            // Conecta-se à tag NFC

            ndef.writeNdefMessage(message)
            // Escreve a mensagem NDEF na tag NFC

            ndef.close()
            // Fecha a conexão com a tag NFC
        }
    }
}
