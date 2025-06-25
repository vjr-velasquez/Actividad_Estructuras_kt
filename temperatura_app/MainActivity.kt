package com.vvelasquez.temperaturaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etCelsius: EditText
    private lateinit var btnConvertir: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar vistas
        etCelsius = findViewById(R.id.et_celsius)
        btnConvertir = findViewById(R.id.btn_convertir)
        txtResultado = findViewById(R.id.txt_resultado)

        // Configurar botón
        btnConvertir.setOnClickListener {
            convertirTemperatura()
        }
    }

    private fun convertirTemperatura() {
        val celsiusTexto = etCelsius.text.toString().trim()

        // Validar que no esté vacío
        if (celsiusTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la temperatura en Celsius", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Convertir texto a número
            val celsius = celsiusTexto.toDouble()

            // Aplicar fórmula: °F = (°C × 9/5) + 32
            val fahrenheit = (celsius * 9.0 / 5.0) + 32

            // Mostrar resultado formateado
            txtResultado.text = "${celsius}°C = ${String.format("%.1f", fahrenheit)}°F"

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor, ingrese un número válido", Toast.LENGTH_SHORT).show()
        }
    }
}