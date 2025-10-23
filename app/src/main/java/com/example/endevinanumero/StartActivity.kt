package com.example.endevinanumero

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.endevinanumero.MainActivity.Companion.StartActivity_KEY
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StartActivity : AppCompatActivity() {
    private var isBtn1selected: Boolean = true
    private var isBtn2selected: Boolean = false
    private var isBtn3selected: Boolean = false
    lateinit var tvTittle_start: TextView


    lateinit var fab1: FloatingActionButton
    lateinit var fab2: FloatingActionButton
    lateinit var fab3: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val user: String = intent.extras?.getString(StartActivity_KEY) ?: "invitado"
        initComponents()
        initUi(user)
        initListeners()
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
    }

    private fun initComponents(){
        tvTittle_start = findViewById(R.id.tvTittle_start)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        fab3 = findViewById(R.id.fab3)

        fab1.imageTintList = null
        fab2.imageTintList = null
        fab3.imageTintList = null
    }

    private fun initUi(user: String){
        when(user){
            "" -> tvTittle_start.text = "Benvingut: Invitat"
            else -> tvTittle_start.text = "Benvingut: $user"
        }
        changeBtn(1)
        setBtnColor()
    }

}