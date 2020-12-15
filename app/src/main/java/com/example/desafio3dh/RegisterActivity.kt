package com.example.desafio3dh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toolbar

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        setSupportActionBar(findViewById(R.id.toolbarRegister))
//        findViewById<Toolbar>(R.id.toolbarRegister).setNavigationOnClickListener {
//         onBackPressed()

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))

        }

        }



        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }

    }
