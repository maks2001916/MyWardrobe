package com.example.mywardrobe

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class ClothingInfoActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var imageCIV: CircleImageView
    private lateinit var titleTV: TextView
    private lateinit var descriptionTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_clothing_info)

        init()

    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarInfoTB)
        imageCIV = findViewById(R.id.imageInfoCIV)
        titleTV = findViewById(R.id.titleInfoTV)
        descriptionTV = findViewById(R.id.descriptionInfoTV)
        setSupportActionBar(toolbarTB)
    }
}