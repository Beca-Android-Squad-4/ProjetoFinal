package com.example.projetofinalquad4.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.databinding.InfoFragmentBinding
import com.example.projetofinalquad4.view.viewModel.MainViewModel

class InfoFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
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

        viewModel.coinDtoId.observe(viewLifecycleOwner) { coinId ->
            Log.d("CoinRecive", "onActivityCreated: $coinId")
            if (coinId.isNotEmpty()) {
                binding.tvCoinName.text = coinId

            //listOf(setListAdapter(mockCoinDto().filter { it.id.equals(coinId) }))
            }
        }
    }

   // private fun setListAdapter(list: List<CoinDto>) {
   private fun setListAdapter(list: List<CoinItem>) {
        adapter.submitList(list)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
