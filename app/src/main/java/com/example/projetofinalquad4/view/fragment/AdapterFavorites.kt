package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.FavoritesFragmentBinding
import com.example.projetofinalquad4.databinding.ItemFavoritesBinding

//class AdapterFavorites : ListAdapter<CoinDto, AdapterFavorites.ViewHolder>(DIFF_CALLBACK) {

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

       /* fun bind(x: CoinDto) {
            binding.tvNameFavorite.text = x.name
            binding.tvPriceFavorite.text = x.rank.toString()
        }*/

        fun bind(x: CoinItem) {
            binding.tvNameFavorite.text = x.name
            binding.tvPriceFavorite.text = x.price_usd.toString()
        }
    }

    companion object {
        //private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinDto>() {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinItem>() {
            //override fun areItemsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
            override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
               // return oldItem.id == oldItem.id
                return oldItem.asset_id == oldItem.asset_id
            }

           // override fun areContentsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
           override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem == oldItem
            }
        }
    }
}
