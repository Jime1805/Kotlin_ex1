package com.example.endevinanumero

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.endevinanumero.MainActivity.Companion.StartActivity_KEY

class StartActivity : AppCompatActivity() {

    lateinit var tvTittle_start: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        tvTittle_start = findViewById(R.id.tvTittle_start)
        val user: String = intent.extras?.getString(StartActivity_KEY) ?: "invitado"
        initUi(user)
    }

    private fun initUi(user: String){
        when(user){
            "" -> tvTittle_start.text = "Benvingut: Invitat"
            else -> tvTittle_start.text = "Benvingut: $user"
        }
    }

}