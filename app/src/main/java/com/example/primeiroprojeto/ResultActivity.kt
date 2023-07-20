package com.example.primeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result=  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text= result.toString()
        /* TABELA IMC
        MENOR QUE 18,5     ABAIXO DO PESO  0
        ENTRE 18,5 E 24,9  NORMAL  0
        ENTRE 25 E 29,9    SOBREPESO I
        ENTRE 30 E 39,9    SOBREPESO II
        MAIOR QUE 40       SOBREPESO III
        */
        var classificacao= ""

        if (result <18.5f)
            classificacao= "Abaixo do peso"
        else if (result in 18.5f..24.9f)
            classificacao= "Normal"
        else if (result in 25f..29.9f)
            classificacao= "SOBREPESO"
        else if (result in 30.0..39.9)
            classificacao= "OBESIDADE"
        else if (result >=40)
            classificacao= "OBESIDADE GRAVE"

        tvClassificacao.text = getString(R.string.message_classificação, classificacao)



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}