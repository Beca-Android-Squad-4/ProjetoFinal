package com.example.projetofinalquad4.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.InfoFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.view.viewModel.MainViewModel

class InfoFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels() { Helpers.getMainViewModelFactory() }
    private lateinit var adapter: AdapterInfo
    private var _binding: InfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InfoFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        setupAdapter()

        return view
    }

    private fun setupAdapter() {
        adapter = AdapterInfo()
        binding.recyclerView.adapter = adapter

        getData()
    }

    private fun getData() {

        viewModel.coinSelected.observe(viewLifecycleOwner) { coin ->
            Log.d("CoinRecive", "onActivityCreated: $coin")
            binding.tvCoinName.text = coin.name
            binding.tvCoinPrice.text = coin.price_usd.toString()
            binding.tvPriceHour.text = coin.volume_1hrs_usd.toString()
            binding.tvPriceDay.text = coin.volume_1day_usd.toString()
            binding.tvPriceMonth.text = coin.volume_1mth_usd.toString()

            Glide.with(requireContext())
                .load(coin.icon_url)
                .centerCrop()
                .into(binding.imageView)
        }
    }

    private fun setListAdapter(list: List<CoinItem>) {
        adapter.submitList(list)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
