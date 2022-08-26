package com.example.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val btnLogar: Button = findViewById(R.id.btnlogin)
        btnLogar.setOnClickListener{
            performedLogar()
        }

        val btnCadastrarUsuario: Button = findViewById(R.id.btnregistrar)
        btnCadastrarUsuario.setOnClickListener {
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

    }

    private fun performedLogar(){
        val edtLogin: EditText = findViewById(R.id.usuario)
        val edtSenha: EditText = findViewById(R.id.senha)

        val inputLogin = edtLogin.text.toString()
        val inputSenha = edtSenha.text.toString()

        if( inputLogin.isEmpty() || inputSenha.isEmpty()){
            Toast.makeText(this, "O campo login ou senha está em branco!", Toast.LENGTH_SHORT).show()
            return
        }


        auth.signInWithEmailAndPassword(inputLogin, inputSenha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, resposta::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Usuário ou senha incorretos!!", Toast.LENGTH_SHORT).show()
                }
        }

    }



}