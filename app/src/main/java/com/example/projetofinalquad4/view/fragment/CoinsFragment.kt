package com.example.projetofinalquad4.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import com.example.projetofinalquad4.data.remote.dto.mockCoinDto
import com.example.projetofinalquad4.databinding.MainFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.viewModel.MainViewModel

class CoinsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterCoins
    private lateinit var listResponse: MutableList<CoinDto>
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

    private fun setupSearchView(list: List<CoinDto>) {
        var newList: MutableList<CoinDto> = ArrayList()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                newList = Helpers.FilterListQuery(query, list)
                // Log.d("QuerySubmit", "onQueryTextSubmit: $newList")
                setlistQueryAdapter(newList)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // binding.searchView.clearFocus()
                newList = Helpers.FilterListQuery(newText, list)
                // Log.d("QuerySubmit", "onQueryTextSubmit: $newList")
                setlistQueryAdapter(newList)
                return true
            }
        })
    }

    private fun setlistQueryAdapter(newList: MutableList<CoinDto>) {
        if (newList.isNotEmpty()) {
            setListAdapter(newList)
        } else Helpers.ToastText(
            "Não existe essa moeda",
            requireContext()
        )
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
        // Aqui será usado o viewModel

        listResponse = mockCoinDto().toMutableList()

        setListAdapter(listResponse)
    }

    private fun setListAdapter(list: List<CoinDto>) {
        adapter.submitList(list)
        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSearchView(listResponse)

        adapter.onClickListener = { coinId ->
            viewModel.SetListCoins(coinId)
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
