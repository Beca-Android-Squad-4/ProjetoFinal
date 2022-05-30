package com.example.projetofinalquad4.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.InfoFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.view.viewModel.MainViewModel

class InfoFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels() { Helpers.getMainViewModelFactory() }
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

        binding.btnReturn.setOnClickListener {
            replaceFragment(CoinsFragment())
        }

        return view
    }

    private fun setupAdapter() {

        getData()
    }

    private fun getData() {

        viewModel.coinSelected.observe(viewLifecycleOwner) { coin ->
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@observe
            if (sharedPref.all.containsKey(coin.asset_id)) {
                binding.ivFavorite.visibility = View.VISIBLE
                binding.btnAddFavorite.text = "REMOVER"
            } else {
                binding.ivFavorite.visibility = View.GONE
                binding.btnAddFavorite.text = "ADICIONAR"
            }

            Log.d("CoinRecive", "onActivityCreated: $coin")
            binding.tvCoinName.text = coin.name
            binding.tvCoinPrice.text = Helpers.formatPriceCoin(coin.price_usd)
            binding.tvPriceHour.text = Helpers.formatPriceCoin(coin.volume_1hrs_usd)
            binding.tvPriceDay.text = Helpers.formatPriceCoin(coin.volume_1day_usd)
            binding.tvPriceMonth.text = Helpers.formatPriceCoin(coin.volume_1mth_usd)

            if (!coin.icon_url.isNullOrEmpty()) {
                Glide.with(requireContext())
                    .load(coin.icon_url)
                    .centerCrop()
                    .into(binding.imageView)
            } else {
                Glide.with(requireContext())
                    .load(R.drawable.generic_coin)
                    .centerCrop()
                    .into(binding.imageView)
            }

            binding.btnAddFavorite.setOnClickListener {
                when (coin.isFavorite) {
                    true -> { // Vai remover dos favoritos
                        sharedPref.edit().remove(coin.asset_id).apply()
                        viewModel.setFavorite(false)
                        binding.btnAddFavorite.text = "ADICIONAR"
                        binding.ivFavorite.visibility = View.GONE
                    }
                    false -> { // Vai adicionar aos favoritos
                        sharedPref.edit().putString(coin.asset_id, coin.asset_id).apply()
                        viewModel.setFavorite(true)
                        binding.btnAddFavorite.text = "REMOVER"
                        binding.ivFavorite.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_fragment, fragment)
        fragmentTransaction?.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
