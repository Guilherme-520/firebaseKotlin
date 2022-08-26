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

class Registrar : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        auth = Firebase.auth

        val btnCadastrar: Button = findViewById(R.id.btncadastro)
        btnCadastrar.setOnClickListener {
            performedCadastrar()
        }
    }

    private fun performedCadastrar(){
        val edtLogin: EditText = findViewById(R.id.usuario)
        val edtSenha: EditText = findViewById(R.id.senha)

        val inputLogin = edtLogin.text.toString()
        val inputSenha = edtSenha.text.toString()

        if( inputLogin.isEmpty() || inputSenha.isEmpty()){
            Toast.makeText(this, "o campo do usuário ou senha está em branco!", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(inputLogin, inputSenha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT)
                        .show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Erro ao realizar o cadastro!", Toast.LENGTH_SHORT).show()
                }

            }


    }



}