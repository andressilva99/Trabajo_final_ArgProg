package com.example.trabajo_final_argprog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var CajaText1: EditText
    private lateinit var CajaText2: EditText
    private lateinit var textView_Mostrar: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnComparacion).setOnClickListener {
            addComparar(it)
        }
        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            addLimpiar(it)
        }
    }
    private fun addLimpiar(view: View){
        CajaText1.text.clear()
        CajaText2.text.clear()
        textView_Mostrar.visibility=View.GONE
    }

    private fun addComparar(view: View){
        CajaText1 = findViewById(R.id.CajaText1)
        CajaText2 = findViewById(R.id.CajaText2)
        textView_Mostrar = findViewById(R.id.textView_Mostrar)

        val text1 = CajaText1.text.toString()
        val text2 = CajaText2.text.toString()
        val comparacionTextView = textView_Mostrar.toString()

        if (text1 == text2){
            textView_Mostrar.visibility=View.VISIBLE
            textView_Mostrar.text = "Los Textos son iguales!"
        }else {
            textView_Mostrar.visibility=View.VISIBLE
            textView_Mostrar.text = "Los textos no son iguales!"
        }
        //comparacionTextView.text=CajaText2.text
        //editText.visibility=View.GONE
        //view.visibility=View.GONE

        //comparacionTextView.visibility=View.VISIBLE

        //ocultar el teclado hide
        val imm =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}