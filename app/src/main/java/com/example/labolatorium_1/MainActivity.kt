package com.example.labolatorium_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonUp:Button
    private lateinit var buttonPl:Button
    private lateinit var buttonMi:Button
    var licznik = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        licznik = savedInstanceState?.getInt("Licznik")?:0
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textview = findViewById<TextView>(R.id.textView)
        textview.text = licznik.toString()
        val textNum = findViewById<EditText>(R.id.textNumber)


        buttonUp=findViewById<Button>(R.id.buttonUpdate)
        buttonUp.setOnClickListener {
            licznik = textNum.text.toString().toInt()
            textview.text=textNum.text.toString()
        }

        buttonPl=findViewById<Button>(R.id.buttonPlus)
        buttonPl.setOnClickListener {
            licznik += 1
            textview.text=licznik.toString()
        }

        buttonMi=findViewById<Button>(R.id.buttonMinus)
        buttonMi.setOnClickListener {
            licznik -= 1
            textview.text=licznik.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Licznik", licznik)
    }
}