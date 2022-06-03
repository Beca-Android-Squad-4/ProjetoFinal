package com.example.projetofinalquad4.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.FavoritesFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.view.viewModel.MainViewModel
import com.nttdata.test.backend.data.remote.dto.CoinApiResult
import com.nttdata.test.backend.data.remote.dto.CoinItem

class FavoritesFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels { Helpers.getMainViewModelFactory() }
    private lateinit var adapter: AdapterFavorites
    private var _binding: FavoritesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var errorFragment: ErrorFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoritesFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        // binding.include.tvMainDate.text = Helpers.GetCalendarDate()

        setupAdapter()

        adapter.onClickListener = { coinId ->
            viewModel.setCoin(coinId)
            replaceFragment(InfoFragment())
        }

        return view
    }

    private fun setupAdapter() {
        adapter = AdapterFavorites()

        val layoutManager = GridLayoutManager(activity, 2)
        layoutManager.orientation = RecyclerView.VERTICAL

        binding.recyclerViewFavorites.layoutManager = layoutManager

        binding.recyclerViewFavorites.adapter = adapter

        viewModel.coinItem.observe(viewLifecycleOwner) { listCoins ->
            // listCoins as List<CoinItem>
            getFavorites(listCoins)
        }
    }

    private fun getFavorites(list: CoinApiResult<List<CoinItem>>) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        Log.d("ListFavorites", "getFavorites: ${sharedPref.all}")
        val tempList: MutableList<CoinItem> = ArrayList()
        when (list) {
            is CoinApiResult.Success -> {
                list.data.forEach {
                    if (sharedPref.all.contains(it.asset_id)) {
                        tempList.add(it)
                    }
                }
            }

            is CoinApiResult.Error -> {
                errorFragment = ErrorFragment()
                replaceFragment(ErrorFragment())
            }
        }

        Log.d(
            "ListFilter",
            "getFavorites: $tempList"
        )
        // val defaultValue = resources.getInteger()

        adapter.submitList(tempList)
        // val highScore = sharedPref.getInt(, defaultValue)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_fragment, fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}
