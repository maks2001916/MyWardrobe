package com.example.mywardrobe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CustomAdapter(private val clothes: MutableList<Clothing>):
RecyclerView.Adapter<CustomAdapter.UserViewHolder>(){

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCIV = itemView.findViewById<CircleImageView>(R.id.imageCIV)
        val titleTV = itemView.findViewById<TextView>(R.id.titleTV)
        val descriptionTV = itemView.findViewById<TextView>(R.id.descriptionTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount() = clothes.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val clothing = clothes[position]
        holder.imageCIV.setImageResource(clothing.image.toInt())
        holder.titleTV.text = clothing.title
        holder.descriptionTV.text = clothing.description
    }
}