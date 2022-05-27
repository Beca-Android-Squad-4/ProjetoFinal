package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.ItemCoinBinding

class AdapterCoins : ListAdapter<CoinItem, AdapterCoins.ViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((coinId: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemCoinBinding,
        private val onClickListener: ((coinId: String) -> Unit)? = null
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(x: CoinItem) {
            binding.tvCoinNameItem.text = x.name
            binding.tvCoinPriceItem.text = x.price_usd.toString()

            binding.root.setOnClickListener {
                onClickListener?.invoke(x.asset_id)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinItem>() {
            override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem.asset_id == newItem.asset_id
            }

            override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
