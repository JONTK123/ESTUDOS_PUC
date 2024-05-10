package com.example.camerax

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.camerax.databinding.ActivityMainBinding
import android.Manifest
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val cameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            abrirTelaDePreview()
        } else {
            Toast.makeText(this, "Você não concedeu permissão para usar a câmera", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenCamera.setOnClickListener {
            solicitarPermissaoCamera()
        }
    }

    private fun solicitarPermissaoCamera() {
        cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
    }

    private fun abrirTelaDePreview() {
        val intent = Intent(this, CameraPreviewActivity::class.java)
        startActivity(intent)
    }
}
