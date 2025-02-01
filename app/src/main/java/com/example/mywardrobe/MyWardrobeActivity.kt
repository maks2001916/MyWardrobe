package com.example.mywardrobe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyWardrobeActivity : AppCompatActivity() {

    private lateinit var clothes: MutableList<Clothing>

    private lateinit var toolbarTB: Toolbar
    private lateinit var listRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_wardrobe)

        initClothesList()
        init()

    }

    private fun initClothesList() {
        clothes = mutableListOf(
            Clothing(
                R.drawable.jacket.toString(),
                getString(R.string.jacket),
                getString(R.string.jacket_description)
            ),
            Clothing(
                R.drawable.baseball_cap.toString(),
                getString(R.string.baseball_cap),
                getString(R.string.baseball_cap_description)
            ),
            Clothing(
                R.drawable.belt.toString(),
                getString(R.string.belt),
                getString(R.string.belt_description)
            ),
            Clothing(
                R.drawable.butterfly.toString(),
                getString(R.string.butterfly),
                getString(R.string.butterfly_description)
            ),
            Clothing(
                R.drawable.pants.toString(),
                getString(R.string.pants),
                getString(R.string.pants_description)
            ),
            Clothing(
                R.drawable.shirt.toString(),
                getString(R.string.shirt),
                getString(R.string.shirt_description)
            ),
            Clothing(
                R.drawable.shoes.toString(),
                getString(R.string.shoes),
                getString(R.string.shoes_description)
            ),
            Clothing(
                R.drawable.shorts.toString(),
                getString(R.string.shorts),
                getString(R.string.shorts_description)
            ),
            Clothing(
                R.drawable.sleeveless_vest.toString(),
                getString(R.string.sleeveless_vest),
                getString(R.string.sleeveless_vest_description)
            ),
            Clothing(
                R.drawable.slippers.toString(),
                getString(R.string.slippers),
                getString(R.string.slippers_description)
            ),
            Clothing(
                R.drawable.sneakers.toString(),
                getString(R.string.sneakers),
                getString(R.string.sneakers_description)
            ),
            Clothing(
                R.drawable.socks.toString(),
                getString(R.string.socks),
                getString(R.string.socks_description)
            ),
            Clothing(
                R.drawable.sweater.toString(),
                getString(R.string.sweater),
                getString(R.string.sweater_description)
            ),
            Clothing(
                R.drawable.t_shirt.toString(),
                getString(R.string.t_shirt),
                getString(R.string.t_shirt_description)
            ),
            Clothing(
                R.drawable.tie.toString(),
                getString(R.string.tie),
                getString(R.string.tie_description)
            ),
            Clothing(
                R.drawable.trousers.toString(),
                getString(R.string.trousers),
                getString(R.string.trousers_description)
            ),
            Clothing(
                R.drawable.undershirt.toString(),
                getString(R.string.undershirt),
                getString(R.string.undershirt_description)
            ),
            Clothing(
                R.drawable.wallet.toString(),
                getString(R.string.wallet),
                getString(R.string.wallet_description)
            ),
            Clothing(
                R.drawable.watch.toString(),
                getString(R.string.watch),
                getString(R.string.watch_description)
            ),
            Clothing(
                R.drawable.windbreaker.toString(),
                getString(R.string.windbreaker),
                getString(R.string.windbreaker_description)
            )
        )
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarMyWardrobeTB)
        listRV = findViewById(R.id.listRV)
        listRV.layoutManager = LinearLayoutManager(this)
        val customAdapter = CustomAdapter(clothes)
        listRV.adapter = customAdapter
        listRV.setHasFixedSize(true)
        customAdapter.setOnClothingClickListener(object :
            CustomAdapter.OnClothingClickListener {
            override fun onClothingClick(clothing: Clothing, position: Int) {
                val intent = Intent(this@MyWardrobeActivity, ClothingInfoActivity::class.java)
                intent.putExtra("image", clothing.image)
                intent.putExtra("title", clothing.title)
                intent.putExtra("description", clothing.description)
                intent.putExtra("position", position)
                startActivity(intent)
                launchSomeActivity.launch(intent)
            }

        })
        setSupportActionBar(toolbarTB)

    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val position = data?.getIntExtra("position", -1) ?: -1
                val newTitle = data?.getStringExtra("editTitle") ?: ""
                val newDescription = data?.getStringExtra("newDescription") ?: ""

                if (position == -1) {
                    clothes[position].title = newTitle
                    clothes[position].description = newDescription
                }

                listRV.adapter?.notifyItemChanged(position)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.wardrobe_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {R.id.exit -> finishAffinity() }
        return super.onOptionsItemSelected(item)
    }

}