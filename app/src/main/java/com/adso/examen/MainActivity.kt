package com.adso.examen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adso.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.kilometros.setOnClickListener { KmConversion() }
        binding.centimetros.setOnClickListener { CmConversion() }
        binding.milimetros.setOnClickListener { MmConversion() }
        binding.decametros.setOnClickListener { DamConversion() }
    }

    private fun KmConversion() {
        val metrosIngresados = binding.metrosIngresados.text.toString().toDoubleOrNull() ?: return
        val km = metrosIngresados / 1000
        mostrarResultado("$metrosIngresados metros son $km km")
    }

    private fun CmConversion() {
        val metrosIngresados = binding.metrosIngresados.text.toString().toDoubleOrNull() ?: return
        val cm = metrosIngresados * 100
        mostrarResultado("$metrosIngresados metros son $cm cm")
    }

    private fun MmConversion() {
        val metrosIngresados = binding.metrosIngresados.text.toString().toDoubleOrNull() ?: return
        val mm = metrosIngresados * 1000
        mostrarResultado("$metrosIngresados metros son $mm mm")
    }

    private fun DamConversion() {
        val metrosIngresados = binding.metrosIngresados.text.toString().toDoubleOrNull() ?: return
        val dam = metrosIngresados * 0.1
        mostrarResultado("$metrosIngresados metros son $dam decametros")
    }

    private fun mostrarResultado(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
