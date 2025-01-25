package com.example.mypc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PCAdapter(private val context: Context, private val pcList: List<PCItem>) :
    RecyclerView.Adapter<PCAdapter.PCViewHolder>() {

    inner class PCViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pcImage: ImageView = itemView.findViewById(R.id.img_pc)
        val pcTitle: TextView = itemView.findViewById(R.id.tv_title)
        val pcDescription: TextView = itemView.findViewById(R.id.tv_description)

        fun bind(item: PCItem) {
            pcImage.setImageResource(item.image)
            pcTitle.text = item.title
            pcDescription.text = item.description

            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("PC_DATA", item) // Kirim data PCItem ke DetailActivity
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pc, parent, false)
        return PCViewHolder(view)
    }

    override fun onBindViewHolder(holder: PCViewHolder, position: Int) {
        holder.bind(pcList[position])
    }

    override fun getItemCount() = pcList.size
}
