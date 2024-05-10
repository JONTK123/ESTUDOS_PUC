package com.example.camerax

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.example.camerax.databinding.YourBindingClassBinding
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class CameraPreviewActivity : AppCompatActivity() {

    private lateinit var binding: YourBindingClassBinding
    private lateinit var cameraProviderFuture: ProcessCameraProvider
    private lateinit var cameraSelector: CameraSelector
    private var imageCapture: ImageCapture? = null
    private lateinit var imgCaptureExecutor: Executor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_camera_preview)

        binding = YourBindingClassBinding.bind(findViewById(R.id.rootLayout))
        imgCaptureExecutor = Executors.newSingleThreadExecutor()
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

        startCamera()

        binding.btntakePhoto.setOnClickListener {
            takePhoto()
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                blinkPreview()
            }
        }
    }

    private fun startCamera() {
        cameraProviderFuture.addListener(Runnable {
            imageCapture = ImageCapture.Builder().build()

            val cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.previewView.surfaceProvider)
            }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview, imageCapture)
            } catch (e: Exception) {
                Log.e("CameraXApp", "Erro ao iniciar a câmera", e)
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun takePhoto() {
        imageCapture?.let { capture ->
            val fileName = "FOTO_JPEG_${System.currentTimeMillis()}"
            val file = File(externalMediaDirs[0], "${fileName}.jpg")
            val outputFileOptions = ImageCapture.OutputFileOptions.Builder(file).build()

            capture.takePicture(outputFileOptions, imgCaptureExecutor,
                object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                        Log.i("CameraXApp", "Foto capturada com sucesso: ${file.toURI()}")
                    }

                    override fun onError(exception: ImageCaptureException) {
                        Log.e("CameraXApp", "Erro ao salvar foto", exception)
                    }
                })
        }
    }

    private fun blinkPreview() {
        binding.root.postDelayed({
            binding.root.foreground = ColorDrawable(Color.WHITE)

            binding.root.postDelayed({
                binding.root.foreground = null
            }, 50)
        }, 100)
    }
}
