package com.miso.mockupsmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.ToggleButton
import androidx.core.content.ContextCompat

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val btnCancelar:Button = findViewById(R.id.btn_cancelar)
        val btnGuardar:Button = findViewById(R.id.btn_guardar)


        val btnD:ToggleButton = findViewById(R.id.toggleD)
        val btnL:ToggleButton = findViewById(R.id.toggleL)
        val btnM:ToggleButton = findViewById(R.id.toggleM)
        val btnX:ToggleButton = findViewById(R.id.toggleX)
        val btnJ:ToggleButton = findViewById(R.id.toggleJ)
        val btnV:ToggleButton = findViewById(R.id.toggleV)
        val btnS:ToggleButton = findViewById(R.id.toggleS)

        val opcionesAlarma = arrayOf("Alarma", "Recordatorio", "Concurrente")
        val adapterAlarma = ArrayAdapter<String>(this, R.layout.custom_dropdown_item, opcionesAlarma)
        adapterAlarma.setDropDownViewResource(R.layout.custom_dropdown_poup)
        val spinnerAlarma = findViewById<Spinner>(R.id.spinner_alarma)
        spinnerAlarma.adapter = adapterAlarma
        val opcionesTipo = arrayOf("Sencilla", "Camara", "Movimiento", "Mensaje")
        val adapterTipo = ArrayAdapter<String>(this, R.layout.custom_dropdown_item, opcionesTipo)
        adapterTipo.setDropDownViewResource(R.layout.custom_dropdown_poup)
        val spinnerTipo = findViewById<Spinner>(R.id.spinner_tipo)
        spinnerTipo.adapter = adapterTipo

        val hourPicker = findViewById<NumberPicker>(R.id.numberPickerH)
        hourPicker.minValue = 0
        hourPicker.maxValue = 23
        hourPicker.value = 12 // valor por defecto


        hourPicker.setFormatter(object : NumberPicker.Formatter {
            override fun format(value: Int): String {
                // Establece el formato de los números en 2 dígitos con ceros a la izquierda
                return String.format("%02d", value)
            }
        })

        val minPicker = findViewById<NumberPicker>(R.id.numberPickerM)
        minPicker.minValue = 0
        minPicker.maxValue = 59
        minPicker.value = 30 // valor por defecto


        minPicker.setFormatter(object : NumberPicker.Formatter {
            override fun format(value: Int): String {
                // Establece el formato de los números en 2 dígitos con ceros a la izquierda
                return String.format("%02d", value)
            }
        })

        btnCancelar.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            finish()
        }

        btnD.setOnClickListener {
            if(btnD.isChecked){
                btnD.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnD.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnD.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnD.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnL.setOnClickListener {
            if(btnL.isChecked){
                btnL.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnL.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnL.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnL.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnM.setOnClickListener {
            if(btnM.isChecked){
                btnM.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnM.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnM.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnM.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnX.setOnClickListener {
            if(btnX.isChecked){
                btnX.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnX.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnX.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnX.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnJ.setOnClickListener {
            if(btnJ.isChecked){
                btnJ.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnJ.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnJ.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnJ.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnV.setOnClickListener {
            if(btnV.isChecked){
                btnV.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnV.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnV.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnV.setBackgroundResource(R.drawable.botones_dias)
            }
        }

        btnS.setOnClickListener {
            if(btnS.isChecked){
                btnS.setTextColor(ContextCompat.getColor(this, R.color.hotpink))
                btnS.setBackgroundResource(R.drawable.boton_dias_on)
            }else{
                btnS.setTextColor(ContextCompat.getColor(this, R.color.iceBlue))
                btnS.setBackgroundResource(R.drawable.botones_dias)
            }
        }





    }
}