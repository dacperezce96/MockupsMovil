package com.miso.mockupsmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ingresarButton:Button = findViewById(R.id.btn_evento)
        val textPhone:EditText = findViewById(R.id.nombre_input)
        val registrarButton:Button = findViewById(R.id.btn_ingresar_aqui)

        ingresarButton.setOnClickListener {
            val textoPhone = textPhone.text.toString()
            if(textoPhone.isEmpty() or textoPhone.isBlank()){
                val mensaje = "Por favor, Digite un numero"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            }else if(textoPhone.length < 10){
                val mensaje = "El numero debe ser de 10 digitos"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            }else if(!TextUtils.isDigitsOnly(textoPhone)){
                val mensaje = "El campo solo debe tener numeros"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            }else{
                val intentCodigo = Intent(this, CodigoCelular::class.java)
                startActivity(intentCodigo)
            }
        }

        registrarButton.setOnClickListener {
            val intentRegistrar = Intent(this, RegistrarActivity::class.java)
            intentRegistrar.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intentRegistrar)
        }

        textPhone.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                textPhone.hint = ""
            } else {
                textPhone.hint = resources.getString(R.string.labe_celular)
            }
        }
    }
}