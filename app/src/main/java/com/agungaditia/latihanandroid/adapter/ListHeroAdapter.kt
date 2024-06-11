package com.agungaditia.latihanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.data.Hero
import com.agungaditia.latihanandroid.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val dataSet: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewAdapter>() {
    class ListViewAdapter(val binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewAdapter(
        ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ListViewAdapter, position: Int) {
        // Untuk menampilkan data pada layout
        val heros = dataSet[position]
        holder.binding.tvItemName.text = heros.name
        holder.binding.tvItemDescription.text = heros.description
        holder.binding.imgItemPhoto.setImageResource(heros.photo)
    }
}