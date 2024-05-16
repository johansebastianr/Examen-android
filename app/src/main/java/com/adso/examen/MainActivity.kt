package com.adso.examen

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.adso.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKm.setOnClickListener { convertToKm() }
        binding.btnCm.setOnClickListener { convertToCm() }
        binding.btnMm.setOnClickListener { convertToMm() }
    }

    private fun convertToKm() {
        val metros = binding.etMetros.text.toString().toDoubleOrNull() ?: return
        val km = metros / 1000
        mostrarAlerta("$metros metros son $km km")
    }

    private fun convertToCm() {
        val metros = binding.etMetros.text.toString().toDoubleOrNull() ?: return
        val cm = metros * 100
        mostrarAlerta("$metros metros son $cm cm")
    }

    private fun convertToMm() {
        val metros = binding.etMetros.text.toString().toDoubleOrNull() ?: return
        val mm = metros * 1000
        mostrarAlerta("$metros metros son $mm mm")
    }

    private fun mostrarAlerta(mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensaje)
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }
}

