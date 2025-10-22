package com.example.endevinanumero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var tvFecha : TextView
    lateinit var btnEnviar : Button
    lateinit var tieMensaje : TextInputEditText

    companion object{
        const val StartActivity_KEY = "StartActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initUi()
        initListeners()
    }

    private fun initListeners(){
        btnEnviar.setOnClickListener{
            val user = tieMensaje.text.toString()
            navigateToStartActivity(user)
        }
    }

    private fun navigateToStartActivity(user: String){
        val intent = Intent(this, StartActivity::class.java)
        intent.putExtra(StartActivity_KEY, user)
        startActivity(intent)
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
        tieMensaje = findViewById(R.id.tieMensaje)
    }
}