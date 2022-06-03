package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.ItemFavoritesBinding
import com.example.projetofinalquad4.utils.Helpers
import com.nttdata.test.backend.data.remote.dto.CoinItem

class AdapterFavorites : ListAdapter<CoinItem, AdapterFavorites.ViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((coinId: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemFavoritesBinding,
        private val onClickListener: ((coinId: String) -> Unit)? = null
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(x: CoinItem) {
            binding.tvNameFavorite.text = x.name
            binding.tvNameAbrevietedFavorite.text = x.asset_id
            binding.tvPriceFavorite.text = "$ " + Helpers.formatPriceCoin(x.price_usd)

            if (!x.icon_url.isNullOrEmpty()) {
                Glide.with(binding.root.context)
                    .load(x.icon_url)
                    .centerCrop()
                    .into(binding.imageView3)
            } else {
                Glide.with(binding.root.context)
                    .load(R.drawable.bitcoin)
                    .centerCrop()
                    .into(binding.imageView3)
            }

            binding.linearLayout2.setOnClickListener {
                onClickListener?.invoke(x.asset_id)
            }
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
