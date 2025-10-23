package com.example.endevinanumero

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.endevinanumero.MainActivity.Companion.StartActivity_KEY
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StartActivity : AppCompatActivity() {
    private val numRandom = numRandom()
    private var isBtn1selected: Boolean = true
    private var isBtn2selected: Boolean = false
    private var isBtn3selected: Boolean = false
    lateinit var tvTittle_start: TextView


    lateinit var fab1: Button
    lateinit var fab2: Button
    lateinit var fab3: Button
    lateinit var btngoBack: Button
    lateinit var btnSend: Button

    companion object{
        const val num_user = "user"
        const val num_random = "random"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val user: String = intent.extras?.getString(StartActivity_KEY) ?: "invitado"
        initComponents()
        initUi(user)
        initListeners()
    }

    private fun numRandom(): Int{
        return (1..3).random()
    }

    private fun numUser(): Int{
        if(isBtn1selected) return 1
        else if(isBtn2selected) return 2
        else return 3
    }

    private fun changeBtn(num : Int){
        isBtn1selected = (num==1)
        isBtn2selected = (num==2)
        isBtn3selected = (num==3)
    }
    private fun setBtnColor(){
        fab1.backgroundTintList = ColorStateList.valueOf(getBackgroundColor(isBtn1selected))
        fab2.backgroundTintList = ColorStateList.valueOf(getBackgroundColor(isBtn2selected))
        fab3.backgroundTintList = ColorStateList.valueOf(getBackgroundColor(isBtn3selected))
    }
    private fun getBackgroundColor(isSelected: Boolean): Int{
        val colorReference = if (isSelected){
            R.color.buton_activated
        } else{
            R.color.buton_startActivity
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initListeners() {
        fab1.setOnClickListener {
            changeBtn(1)
            setBtnColor()
        }
        fab2.setOnClickListener {
            changeBtn(2)
            setBtnColor()
        }
        fab3.setOnClickListener {
            changeBtn(3)
            setBtnColor()
        }
        btngoBack.setOnClickListener { onBackPressed() }
        btnSend.setOnClickListener {
            navigateToNextScreen()
        }
    }
    private fun navigateToNextScreen() {
        val userNumber = numUser()
        if (userNumber == numRandom) {
            navigateToSucces(userNumber)
        } else {
            navigateToError(userNumber)
        }
    }

    private fun navigateToSucces(numUser: Int){
        val intent = Intent(this, SuccessActivity::class.java)
        intent.putExtra(num_user, numUser)
        intent.putExtra(num_random, numRandom)
        startActivity(intent)
    }

    private fun navigateToError(numUser: Int){
        val intent = Intent(this, ErrorActivity::class.java)
        intent.putExtra(num_user, numUser)
        intent.putExtra(num_random, numRandom)
        startActivity(intent)
    }

    private fun initComponents(){
        tvTittle_start = findViewById(R.id.tvTittle_start)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        fab3 = findViewById(R.id.fab3)
        btngoBack = findViewById(R.id.btngoBack)
        btnSend = findViewById(R.id.btnSend)
    }

    private fun initUi(user: String){
        when(user){
            "" -> tvTittle_start.text = "Benvingut: Invitat"
            else -> tvTittle_start.text = "Benvingut: $user"
        }
        changeBtn(1)
        setBtnColor()
        val numero = numRandom()
    }

}