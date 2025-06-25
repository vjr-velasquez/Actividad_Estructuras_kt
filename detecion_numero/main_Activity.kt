package com.vvelasquez.appnumeros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etNumero: EditText
    private lateinit var btnComprobar: Button
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

        //Inicia el codigo
        etNumero = findViewById<EditText>(R.id.et_numero)
        btnComprobar = findViewById<Button>(R.id.btn_comprobar)
        txtResultado = findViewById<TextView>(R.id.txt_resultado)


        // La configuracion del boton
        btnComprobar.setOnClickListener{
            comprobarNumero()
        }
    }

    private fun comprobarNumero(){
        val numeroTexto = etNumero.text.toString().trim() // ❌ CAMBIÉ et_numero por etNumero

        // Validación básica
        if (numeroTexto.isEmpty()) {
            Toast.makeText(this, "Ingrese un número", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            //Convertimos el texto a numero
            val numero = numeroTexto.toDouble()

            when{
                numero > 0 ->{
                    txtResultado.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
                    txtResultado.text = "POSITIVO\n$numero"
                }
                numero < 0 ->{
                    txtResultado.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                    txtResultado.text = "NEGATIVO\n$numero"
                }
                else ->{
                    // Si el numero es igual a cero
                    txtResultado.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
                    txtResultado.text = "IGUAL A CERO\n$numero"
                }
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
        }
    }
}