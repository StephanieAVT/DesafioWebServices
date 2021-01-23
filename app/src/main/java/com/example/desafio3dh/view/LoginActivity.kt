package com.example.desafio3dh.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.desafio3dh.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.tvRegister).setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }
}