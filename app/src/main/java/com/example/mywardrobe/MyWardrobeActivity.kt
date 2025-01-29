package com.example.mywardrobe

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyWardrobeActivity : AppCompatActivity() {

    private var clothes = mutableListOf(
        Clothing(
            R.drawable.jacket.toString(),
            getString(R.string.jacket),
            getString(R.string.jacket_description)),
        Clothing(
            R.drawable.baseball_cap.toString() ,
            getString(R.string.baseball_cap),
            getString(R.string.baseball_cap_descruption)),
        Clothing(
            R.drawable.belt.toString() ,
            getString(R.string.belt),
            getString(R.string.belt_description)),
        Clothing(
            R.drawable.butterfly.toString() ,
            getString(R.string.butterfly),
            getString(R.string.butterfly_description)),
        Clothing(
            R.drawable.pants.toString() ,
            getString(R.string.pants),
            getString(R.string.pants_description)),
        Clothing(
            R.drawable.shirt.toString() ,
            getString(R.string.shirt),
            getString(R.string.shirt_description)),
        Clothing(
            R.drawable.shoes.toString() ,
            getString(R.string.shoes),
            getString(R.string.shoes_description)),
        Clothing(
            R.drawable.shorts.toString() ,
            getString(R.string.shorts),
            getString(R.string.shorts_description)),
        Clothing(
            R.drawable.sleeveless_vest.toString() ,
            getString(R.string.sleeveless_vest),
            getString(R.string.sleeveless_vest_description)),
        Clothing(
            R.drawable.slippers.toString() ,
            getString(R.string.slippers),
            getString(R.string.slippers_description)),
        Clothing(
            R.drawable.sneakers.toString() ,
            getString(R.string.sneakers),
            getString(R.string.sneakers_description)),
        Clothing(
            R.drawable.socks.toString() ,
            getString(R.string.socks),
            getString(R.string.socks_description)),
        Clothing(
            R.drawable.sweater.toString() ,
            getString(R.string.sweater),
            getString(R.string.sweater_description)),
        Clothing(
            R.drawable.t_shirt.toString() ,
            getString(R.string.t_shirt),
            getString(R.string.t_shirt_description)),
        Clothing(
            R.drawable.tie.toString() ,
            getString(R.string.tie), getString(R.string.tie_description)),
        Clothing(
            R.drawable.trousers.toString() ,
            getString(R.string.trousers),
            getString(R.string.trousers_descriprion)),
        Clothing(
            R.drawable.undershirt.toString() ,
            getString(R.string.undershirt),
            getString(R.string.undershirt_description)),
        Clothing(
            R.drawable.wallet.toString() ,
            getString(R.string.wallet),
            getString(R.string.wallet_description)),
        Clothing(
            R.drawable.watch.toString() ,
            getString(R.string.watch), getString(R.string.watch_description)),
        Clothing(
            R.drawable.windbreaker.toString(),
            getString(R.string.windbreaker),
            getString(R.string.windbreaker_description))
        )

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
        listRV.layoutManager = LinearLayoutManager(this)
        listRV.adapter = CustomAdapter(clothes)
        setSupportActionBar(toolbarTB)

    }
}