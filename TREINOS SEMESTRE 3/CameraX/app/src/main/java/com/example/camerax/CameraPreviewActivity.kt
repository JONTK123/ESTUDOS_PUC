package com.example.camerax

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CameraPreviewActivity : AppCompatActivity() {

    // Binding para associar as views do layout XML com variáveis na classe
    private lateinit var binding: YourBindingClass

    // Variável que representa a instância futura do provedor da câmera
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>

    // Variável que representa o seletor de câmera (pode ser usado para selecionar a câmera traseira, frontal, etc.)
    private lateinit var cameraSelector: CameraSelector

    // Variável que representa a captura de imagem
    private lateinit var imageCapture: ImageCapture

    // Executor para captura de imagem
    private lateinit var imgCaptureExecutor: Executor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita o edge-to-edge (vai além das bordas da tela)
        enableEdgeToEdge()

        // Define o layout da atividade
        setContentView(R.layout.your_layout)

        // Inicializa o binding usando a classe gerada pelo data binding
        binding = YourBindingClass.bind(findViewById(R.id.rootLayout))

        // Inicializa o futuro provedor da câmera
        cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        // Inicializa o seletor de câmera com opções de configuração
        cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK) // Exemplo: seleciona a câmera traseira
            .build()

        // Inicializa a captura de imagem
        imageCapture = ImageCapture.Builder()
            .setTargetRotation(binding.previewView.display.rotation)
            .build()

        // Executor para a captura de imagem
        imgCaptureExecutor = ContextCompat.getMainExecutor(this)
    }

    // Função para iniciar a câmera
    private fun startCamera() {
        cameraProviderFuture.addListener({
            // Obtém a instância do provedor da câmera
            val cameraProvider = cameraProviderFuture.get()

            // Cria uma instância do Preview
            val preview = Preview.Builder()
                .build()

            try {
                // Remove todos os casos de uso existentes associados ao LifecycleOwner (neste caso, a atividade)
                cameraProvider.unbindAll()

                // Liga a câmera ao ciclo de vida (LifecycleOwner)
                cameraProvider.bindToLifecycle(
                    this, // LifecycleOwner
                    cameraSelector, // Seletor de câmera
                    preview // Preview
                )

                // Adiciona um uso para a captura de imagem
                val imageCapture = ImageCapture.Builder().build()

            } catch (e: Exception) {
                // Trata qualquer exceção que possa ocorrer
                Log.e("CameraPreviewActivity", "Erro ao ligar a câmera: ${e.message}", e)
            }
        }, ContextCompat.getMainExecutor(this))
    }
}
