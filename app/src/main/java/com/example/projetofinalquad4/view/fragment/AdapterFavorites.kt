package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.ItemFavoritesBinding

class AdapterFavorites : ListAdapter<CoinItem, AdapterFavorites.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: ItemFavoritesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(x: CoinItem) {
            binding.tvNameFavorite.text = x.asset_id
            binding.tvNameAbrevietedFavorite.text = x.name
            binding.tvPriceFavorite.text = x.price_usd.toString()

            Glide.with(binding.root.context)
                .load(x.icon_url)
                .centerCrop()
                .into(binding.imageView3)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinItem>() {
            override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem.asset_id == oldItem.asset_id
            }

            override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem == oldItem
            }
        }
    }
}
