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
