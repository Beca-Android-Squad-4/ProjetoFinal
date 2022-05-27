package com.example.projetofinalquad4.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.ItemInfoDatailsBinding

class AdapterInfo : ListAdapter<CoinItem, AdapterInfo.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemInfoDatailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemInfoDatailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(x: CoinItem) {
            binding.tvUltimosPrecos.text = x.asset_id
        }
    }

    companion object {
        // private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinDto>() {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CoinItem>() {
            // override fun areItemsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
            override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem.asset_id == newItem.asset_id
            }

            // override fun areContentsTheSame(oldItem: CoinDto, newItem: CoinDto): Boolean {
            override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
