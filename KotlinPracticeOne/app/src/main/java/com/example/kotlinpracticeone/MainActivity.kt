package com.example.kotlinpracticeone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById(R.id.buttonclick) as Button
        btn.setOnClickListener(){
            Toast.makeText(this@MainActivity,"Durga puja",Toast.LENGTH_SHORT).show()
        }

        nextIntent.setOnClickListener(){
            val nextGo = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(nextGo)
        }
    }

}

