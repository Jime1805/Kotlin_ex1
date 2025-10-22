package com.example.endevinanumero

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var tvFecha : TextView
    lateinit var btnEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initUi()
    }

    private fun setFecha(){
        val format = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val fecha = LocalDate.now()
        val fechaFormat = fecha.format(format)
        tvFecha.text = fechaFormat.toString()
    }

    private fun initUi(){
        setFecha()
    }


    private fun initComponents(){
        tvFecha = findViewById(R.id.tvFecha)
        btnEnviar = findViewById(R.id.btnEnviar)
    }
}