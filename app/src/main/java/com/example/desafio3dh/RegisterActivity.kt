package com.example.desafio3dh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        setSupportActionBar(findViewById(R.id.toolbarRegister))
//        findViewById<Toolbar>(R.id.toolbarRegister).setNavigationOnClickListener {
//         onBackPressed()
        }
        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }

    }
