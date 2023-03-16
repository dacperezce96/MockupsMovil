package com.miso.mockupsmovil

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner

class CalendarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        val opciones = arrayOf("Día", "Semana", "Mes")
        val adapter = ArrayAdapter<String>(this, R.layout.custom_dropdown_item, opciones)
        adapter.setDropDownViewResource(R.layout.custom_dropdown_poup)
        val mySpinner = findViewById<Spinner>(R.id.spinner_calendario)
        val layoutDia:LinearLayout = findViewById(R.id.contenido_dia)
        val layoutSemana:LinearLayout = findViewById(R.id.contenido_semana)
        val layoutMes:LinearLayout = findViewById(R.id.contenido_mes)
        val buttonGoogle:ImageButton = findViewById(R.id.btn_google)
        val buttonEvento:Button = findViewById(R.id.btn_evento)

        mySpinner.adapter = adapter
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val select = parent.getItemAtPosition(position).toString();
                if(select == "Día"){
                    layoutDia.visibility = View.VISIBLE
                    layoutSemana.visibility = View.GONE
                    layoutMes.visibility = View.GONE
                }else if(select == "Semana"){
                    layoutSemana.visibility = View.VISIBLE
                    layoutDia.visibility = View.GONE
                    layoutMes.visibility = View.GONE
                }else if(select == "Mes"){
                    layoutSemana.visibility = View.GONE
                    layoutDia.visibility = View.GONE
                    layoutMes.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        buttonGoogle.setOnClickListener {
            openUrlInBrowser("https://accounts.google.com/", this)
        }
        buttonEvento.setOnClickListener {
            val intentRegistrar = Intent(this, AlarmActivity::class.java)
            intentRegistrar.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intentRegistrar)
        }
    }

    fun openUrlInBrowser(url: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    }
}