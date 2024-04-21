package br.edu.puccampinas.requests

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL


/***
 * Classe para auxiliar nas operações de HttpRequest e HttpResponse
 * da maneira original no Android, trafegando bytes puramente e
 * convertendo a resposta para texto limpo.
 *
 * Nota importante:
 * A máquina de desenvolvimento, tem o loopback adapter com endereço 127.0.0.1.
 * No entanto, no emulador, o endereço de loopback é reservado para o próprio emulador.
 * para requisitar algo na máquina de desenvolvimento, use o IP 10.0.2.2
 * Mais detalhes você pode consultar aqui:
 * @see { https://developer.android.com/studio/run/emulator-networking }
 * @author Mateus Dias
 */
class ItemsApi {

    private val baseUrl = "http://10.0.2.2:4000/api/"
    private val gson = Gson()

    private fun httpPerformGet(myURL: String?): String { //Aceita uma URL de servidor podendo ser vazia mas nao existe tratamento p caso for vazia, retorna uma string

        val inputStream: InputStream //Armazena/Processa dados binarios recebidos da req HTTP
        val result:String //Resultado da função GET em string
        val url: URL = URL(myURL) //Transforma o URL obtido como parametro na função e a transforma em um tipo URL para ser manipulado dps
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection //Abrimos a conexão com a URL tratada
        conn.connect() //Conectamos com o Servidor

        inputStream = conn.inputStream //Processamos dados da requisição get feita atraves da conexão

        if(inputStream != null) //se nao esiver vazia
            result = inputStreamToString(inputStream) //Transforma em texto string, possivelmente para mostrar o resultado p usuario
        else
            result = "Erro" //Se nao, deu algum erro

        return result
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        val bufferedReader: BufferedReader? = BufferedReader(InputStreamReader(inputStream)) //LeitorbufferedReader le o iput setream. Inputstream carrega os dados da requisicao get 
        var line: String? = bufferedReader?.readLine() // Inicializa a variável line com a primeira linha lida do BufferedReader
        var result:String = "" //Resultado

        while (line != null) { //Enquanto as linhas nao acabarem
            result += line //Acumula as linhas no result
            line = bufferedReader?.readLine() // Passa para proxima linha
        }

        inputStream.close() //Fecha / finaliza a req
        return result //Retorna resultado em string
    }

    private fun httperformPost(url: String, json: String): String {
        val inputStream: InputStream
        val result: String
    
        try {
            val urlObj = URL(url)
            val conn = urlObj.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8")
            conn.doOutput = true
    
            val os = conn.outputStream
            os.write(json.toByteArray(Charsets.UTF_8))
            os.flush()
            os.close()
    
            inputStream = conn.inputStream
            result = inputStreamToString(inputStream)
            inputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
            return "Erro"
        }
    
        return result
    }
    
    fun addNewItem(item: Item): String {
        val itemAdicionado: String = httperfomPost("$baseUrl/items", gson.toJson(item))
        return itemAdicionado
    }
    

    fun getAllItems() : List<Item?>{ //Função que sera chamada na MainActivity, ela tem dentro a httpperfom get
        val itemsPuxados: String = httpPerformGet("$baseUrl/items") //Puxa os items do servidor
        return gson.fromJson(itemsPuxados) //Transforma em json o resultado do get
    }
}

