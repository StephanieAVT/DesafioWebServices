package com.example.desafio3dh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafio3dh.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        findViewById<Button>(R.id.btnSave).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        }



        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }

    }
