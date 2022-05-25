package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import com.example.projetofinalquad4.databinding.ItemCoinBinding

class AdapterCoins : ListAdapter<CoinDto, AdapterCoins.ViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((coinId: String) -> Unit)? = null

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

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
        fun bind(x: CoinDto) {
            binding.tvCoinSymbolItem.text = x.symbol
            binding.tvCoinNameItem.text = x.name
            binding.tvCoinPriceItem.text = x.rank.toString()

            Glide.with(binding.root)
                .load(x.type) // ?????????????????
                .into(binding.ivCoinItem)

            binding.root.setOnClickListener {
                onClickListener?.invoke(x.id)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinDto>() {
            override fun areItemsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
                return oldItem == newItem
            }
        }
    }
}
