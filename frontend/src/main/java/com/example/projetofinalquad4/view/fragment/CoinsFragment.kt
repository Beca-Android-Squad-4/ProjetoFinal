package com.example.projetofinalquad4.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.MainFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.view.viewModel.MainViewModel
import com.nttdata.test.backend.data.remote.dto.CoinApiResult
import com.nttdata.test.backend.data.remote.dto.CoinItem

class CoinsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels() { Helpers.getMainViewModelFactory() }

    private lateinit var adapter: AdapterCoins
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        setupUi()

        return view
    }

    private fun setupSearchView(list: List<CoinItem>) {
        var newList: MutableList<CoinItem> = ArrayList()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                newList = Helpers.FilterListQuery(query, list)
                setlistQueryAdapter(newList)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newList = Helpers.FilterListQuery(newText, list)
                setlistQueryAdapter(newList)
                return true
            }
        })
    }

    private fun setlistQueryAdapter(newList: MutableList<CoinItem>) {
        if (newList.isNotEmpty()) {
            setListAdapter(newList)
            binding.widgetListEmpty.visibility = View.GONE
            binding.rvMainCoins.visibility = View.VISIBLE
            binding.include2.root.visibility = View.VISIBLE
        } else {
            binding.rvMainCoins.visibility = View.GONE
            binding.include2.root.visibility = View.GONE
            binding.widgetListEmpty.visibility = View.VISIBLE
        }
    }

    private fun setupUi() {
        binding.include.tvMainDate.text = Helpers.GetCalendarDate()
        configAdapter()
    }

    private fun configAdapter() {
        adapter = AdapterCoins()

        binding.rvMainCoins.adapter = adapter

        getData()
    }

    private fun getData() {

        viewModel.getCoinsFromRetrofit()
        viewModel.coinItem.observe(viewLifecycleOwner) { listCoins ->
            // Log.d("responseRetrofit", "getData: $listCoins")
            /* val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@observe
             listCoins.forEach { coin ->
                 if (sharedPref.all.containsKey(coin.asset_id)) coin.isFavorite = true
             }
             setListAdapter(listCoins)
             setupSearchView(listCoins)*/

            when (listCoins) {
                is CoinApiResult.Loading<*> -> {
                    Log.d("INFO", "Loading")
                }
                is CoinApiResult.Success<*> -> {
                    Log.d("INFO", "Success")
                    binding.progressBar.visibility = View.GONE
                    binding.include2.root.visibility = View.VISIBLE
                    binding.rvMainCoins.visibility = View.VISIBLE
                    val sharedPref =
                        activity?.getPreferences(Context.MODE_PRIVATE) ?: return@observe

                    (listCoins.data as List<CoinItem>).forEach { coin ->
                        if (sharedPref.all.containsKey(coin.asset_id)) coin.isFavorite = true
                    }
                    setListAdapter(listCoins.data as List<CoinItem>)
                    setupSearchView(listCoins.data as List<CoinItem>)
                }
                is CoinApiResult.Error<*> -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("INFO", "Error.cause: ${listCoins.throwable.cause}")
                    Log.d("INFO", "Error: $listCoins")
                    Log.d("INFO", "Error.message: ${listCoins.throwable.message}")
                }
            }
        }
    }

    private fun setListAdapter(list: List<CoinItem>) {
        adapter.submitList(list)
        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // setupSearchView(listResponse)

        adapter.onClickListener = { coinId ->
            viewModel.setCoin(coinId)
            replaceFragment(InfoFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_fragment, fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}
