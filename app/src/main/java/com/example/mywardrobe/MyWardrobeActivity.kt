package com.example.mywardrobe

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
class MyWardrobeActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var listRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_wardrobe)

        init()

    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarMyWardrobeTB)
        listRV = findViewById(R.id.listRV)
        setSupportActionBar(toolbarTB)
    }
}