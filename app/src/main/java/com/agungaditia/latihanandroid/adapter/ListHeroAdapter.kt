package com.agungaditia.latihanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.data.Hero
import com.agungaditia.latihanandroid.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    // Memuat viewBinding pada code dibawah ini
    class ListViewHolder(val binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        holder.binding.apply {
            tvItemName.text = hero.name
            tvItemDescription.text = hero.description
            imgItemPhoto.setImageResource(hero.photo)
        }
    }
}