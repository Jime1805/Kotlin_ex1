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


class SuccessActivity : AppCompatActivity() {

    lateinit var btngoBack: Button
    lateinit var tvNumRand: TextView
    lateinit var tvNumUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val numUser: Int = intent.extras?.getInt(num_user) ?: 0
        val numRandom: Int = intent.extras?.getInt(num_random) ?: 0
        initComponents()
        initUi(numUser, numRandom)
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
    private fun initUi(numUser: Int, numRandom: Int){
        setNumRand(numRandom)
        setNumUser(numUser)
    }
    private fun initComponents(){
        btngoBack = findViewById(R.id.btngoBack)
        tvNumRand = findViewById(R.id.tvNumRand)
        tvNumUser = findViewById(R.id.tvNumUser)
    }
}