package com.example.mywardrobe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class ClothingInfoActivity : AppCompatActivity() {

    private lateinit var layoutLL: LinearLayout

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
        layoutLL = findViewById(R.id.layoutLL)

        toolbarTB = findViewById(R.id.toolbarInfoTB)
        imageCIV = findViewById(R.id.imageInfoCIV)
        titleTV = findViewById(R.id.titleInfoTV)
        descriptionTV = findViewById(R.id.descriptionInfoTV)
        setSupportActionBar(toolbarTB)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTB.setNavigationOnClickListener { onBackPressed() }
        var clothing: Clothing? = null
        var position: Int = -1
        if (intent.hasExtra("image") &&
            intent.hasExtra("title") &&
            intent.hasExtra("description") &&
            intent.hasExtra("position")) {
            clothing = Clothing(
                intent.getStringExtra("image")!!,
                intent.getStringExtra("title")!!,
                intent.getStringExtra("description")!!)
            position = intent.getIntExtra("position", -1)
        }
        if (clothing != null) {
            imageCIV.setImageResource(clothing.image.toInt())
            titleTV.text = clothing.title
            descriptionTV.text = clothing.description
        }

        layoutLL.setOnLongClickListener {
            val dialog = AlertDialog.Builder(this)
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.update_dialog, null)
            dialog.setView(dialogView)

            val editTitle = dialogView.findViewById<EditText>(R.id.editTitleET) as EditText
            val editDescription = dialogView.findViewById<EditText>(R.id.editDescriptionET) as EditText

            editTitle.setText(titleTV.text.toString())
            editDescription.setText(descriptionTV.text.toString())

            dialog.setTitle(getString(R.string.update_record))
            dialog.setPositiveButton(getString(R.string.update)) {_,_ ->
                intent = Intent()
                intent.putExtra("editTitle", editTitle.text.toString())
                intent.putExtra("editDescription", editDescription.text.toString())
                intent.putExtra("position", intent.getIntExtra("position", -1))
                setResult(RESULT_OK, intent)
                finish()
            }
            dialog.setNegativeButton(getString(R.string.cancel)) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            dialog.show()
            false
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