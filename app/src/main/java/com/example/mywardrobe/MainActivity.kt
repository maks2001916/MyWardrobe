package com.example.mywardrobe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var startBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        init()

        startBTN.setOnClickListener {
            val intent = Intent(this, MyWardrobeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        titleTV = findViewById(R.id.appNameTV)
        startBTN = findViewById(R.id.startBTN)
    }
}