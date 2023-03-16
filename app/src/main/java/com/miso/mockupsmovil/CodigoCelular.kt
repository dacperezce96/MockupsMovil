package com.miso.mockupsmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CodigoCelular : AppCompatActivity() {

    private lateinit var digit1: EditText
    private lateinit var digit2: EditText
    private lateinit var digit3: EditText
    private lateinit var digit4: EditText
    private lateinit var digit5: EditText
    private lateinit var digit6: EditText
    private lateinit var buttonEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_celular)

        // Buscar las referencias de cada EditText
        digit1 = findViewById(R.id.digit1)
        digit2 = findViewById(R.id.digit2)
        digit3 = findViewById(R.id.digit3)
        digit4 = findViewById(R.id.digit4)
        digit5 = findViewById(R.id.digit5)
        digit6 = findViewById(R.id.digit6)
        buttonEntrar = findViewById(R.id.btn_evento)

        // Agregar un TextWatcher en cada EditText
        digit1.addTextChangedListener(MyTextWatcher(digit1, digit2))
        digit2.addTextChangedListener(MyTextWatcher(digit2, digit3))
        digit3.addTextChangedListener(MyTextWatcher(digit3, digit4))
        digit4.addTextChangedListener(MyTextWatcher(digit4, digit5))
        digit5.addTextChangedListener(MyTextWatcher(digit5, digit6))
        digit6.addTextChangedListener(MyTextWatcher(digit6, null))

        buttonEntrar.setOnClickListener {
            val codigo = digit1.text.toString() + digit2.text.toString() + digit3.text.toString() + digit4.text.toString() + digit5.text.toString() + digit6.text.toString()
            if(codigo.length < 6){
                val mensaje = "Codigo invalido"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            }else{
                val intentRegistrar = Intent(this, CalendarioActivity::class.java)
                intentRegistrar.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intentRegistrar)
            }

        }

        digit1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit1.hint = ""
                digit1.setText("")
            } else {
                digit1.hint = resources.getString(R.string.slasH)
            }
        }

        digit2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit2.hint = ""
                digit2.setText("")
                if(digit1.text.toString().isEmpty()) {
                    digit1.requestFocus()
                }
            } else {
                digit2.hint = resources.getString(R.string.slasH)
            }
        }

        digit3.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit3.hint = ""
                digit3.setText("")
                if(digit1.text.toString().isEmpty()) {
                    digit1.requestFocus()
                }
            } else {
                digit3.hint = resources.getString(R.string.slasH)
            }
        }

        digit4.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit4.hint = ""
                digit4.setText("")
                if(digit1.text.toString().isEmpty()) {
                    digit1.requestFocus()
                }
            } else {
                digit4.hint = resources.getString(R.string.slasH)
            }
        }

        digit5.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit5.hint = ""
                digit5.setText("")
                if(digit1.text.toString().isEmpty()) {
                    digit1.requestFocus()
                }
            } else {
                digit5.hint = resources.getString(R.string.slasH)
            }
        }

        digit6.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                digit6.hint = ""
                digit6.setText("")
                if(digit1.text.toString().isEmpty()) {
                    digit1.requestFocus()
                }
            } else {
                digit6.hint = resources.getString(R.string.slasH)
            }
        }


    }

    private inner class MyTextWatcher(
        private val currentEditText: EditText,
        private val nextEditText: EditText?
    ) : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // No se necesita implementar
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Si se ha ingresado un dígito, avanzar automáticamente al siguiente EditText
            if (s?.length == 1 && nextEditText != null) {
                nextEditText.requestFocus()
            }
        }

        override fun afterTextChanged(s: Editable?) {
            // No se necesita implementar
        }
    }

}