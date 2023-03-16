package com.miso.mockupsmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val registrarButton:Button = findViewById(R.id.btn_evento)
        val ingresarButton:Button = findViewById(R.id.btn_ingresar_aqui)
        val nombreInput:EditText = findViewById(R.id.nombre_input)
        val emailInput:EditText = findViewById(R.id.email_input)
        val numInput:EditText = findViewById(R.id.num_cel_input)

        numInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                numInput.hint = ""
            } else {
                numInput.hint = resources.getString(R.string.labe_celular)
            }
        }

        emailInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                emailInput.hint = ""
            } else {
                emailInput.hint = resources.getString(R.string.label_email)
            }
        }

        nombreInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                nombreInput.hint = ""
            } else {
                nombreInput.hint = resources.getString(R.string.label_nombre)
            }
        }

        ingresarButton.setOnClickListener {
            finish()
        }

        registrarButton.setOnClickListener {
            val textoNombre = nombreInput.text.toString()
            val textoEmail  = emailInput.text.toString()
            val textoNumero = numInput.text.toString()
            val emailPattern = Pattern.compile(
                "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$"
            )
            var mensaje = ""

            if(textoNombre.isEmpty() or textoNombre.isBlank()){
                mensaje += "Por favor, Digite un nombre"
            }else if(textoNombre.length < 3){
                mensaje += "El tamaño del nombre debe ser mayor a 3 caracteres"
            }

            if(mensaje.isNotEmpty()){
                mensaje += "\n"
            }

            if(textoEmail.isEmpty() or textoEmail.isBlank()){
                mensaje += "Por favor, Digite el email"
            }else if(!emailPattern.matcher(textoEmail).matches()){
                mensaje += "Debe digitar un email valido"
            }

            if(mensaje.isNotEmpty()){
                mensaje += "\n"
            }

            if(textoNumero.isEmpty() or textoNumero.isBlank()){
                mensaje += "Por favor, Digite un numero"
            }else if(textoNumero.length < 10){
                mensaje += "El numero debe ser de 10 digitos"
            }else if(!TextUtils.isDigitsOnly(textoNumero)){
                mensaje += "El campo solo debe tener numeros"
            }

            if(mensaje.isEmpty()){
                finish()
            }else{
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            }

        }

    }
}