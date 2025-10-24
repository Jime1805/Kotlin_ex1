package com.example.endevinanumero

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.endevinanumero.StartActivity.Companion.num_random
import com.example.endevinanumero.StartActivity.Companion.num_user
import com.example.endevinanumero.StartActivity.Companion.usuari


class SuccessActivity : AppCompatActivity() {

    lateinit var btngoBack: Button
    lateinit var tvNumRand: TextView
    lateinit var tvNumUser: TextView
    lateinit var tvUsuari: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val numUser: Int = intent.extras?.getInt(num_user) ?: 0
        val numRandom: Int = intent.extras?.getInt(num_random) ?: 0
        val user: String = intent.extras?.getString(usuari) ?: "invitado"
        initComponents()
        initUi(numUser, numRandom, user)
        initListeners()
    }
    private fun initListeners(){
        btngoBack.setOnClickListener { onBackPressed() }
    }
    private fun setNumUser(numUser: Int){
        tvNumUser.text = "El teu número: $numUser"
    }
    private fun setNumRand(numRandom: Int){
        tvNumRand.text = "Número a encertar: $numRandom"
    }
    private fun setUsuari(user: String){
        when(user){
            "" -> tvUsuari.text = "Usuari: Invitat"
            else -> tvUsuari.text = "Usuari: $user"
        }
    }
    private fun initUi(numUser: Int, numRandom: Int, user: String){
        setNumRand(numRandom)
        setNumUser(numUser)
        setUsuari(user)
    }
    private fun initComponents(){
        btngoBack = findViewById(R.id.btngoBack)
        tvNumRand = findViewById(R.id.tvNumRand)
        tvNumUser = findViewById(R.id.tvNumUser)
        tvUsuari = findViewById(R.id.tvUsuari)
    }
}