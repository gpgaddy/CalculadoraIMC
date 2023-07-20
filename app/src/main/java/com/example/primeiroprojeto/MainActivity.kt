package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btncalcular:Button = findViewById(R.id.btnCalcular)
        val edtAltura: EditText= findViewById(R.id.edtAltura)
        val edtPeso : EditText= findViewById(R.id.edtPeso)


        btncalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
            val peso: Float = edtPeso.text.toString().toFloat()
            val altura: Float = edtAltura.text.toString().toFloat()

            val altura_final: Float = altura * altura
            val result: Float = peso / altura_final

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)
            } else {
             Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }


    }
 }