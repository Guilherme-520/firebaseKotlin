package com.example.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class resposta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)


        val btnDeslogar: Button = findViewById(R.id.voltar)
        btnDeslogar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

    }
}