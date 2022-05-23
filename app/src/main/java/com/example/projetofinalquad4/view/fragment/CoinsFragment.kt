package com.example.projetofinalquad4.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import com.example.projetofinalquad4.data.remote.dto.mockCoinDto
import com.example.projetofinalquad4.databinding.MainFragmentBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.viewModel.MainViewModel

class CoinsFragment : Fragment() {

    companion object {
        fun newInstance() = CoinsFragment()
    }

    private lateinit var viewModel: MainViewModel
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

        setupSearchView(listResponse)

        return view
    }

    private fun setupSearchView(list: List<CoinDto>) {
        var newList: MutableList<CoinDto> = ArrayList()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                newList = Helpers.FilterListQuery(query)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        if (newList.isNotEmpty()) setListAdapter(newList) else Helpers.ToastText(
            "Não existe essa moeda",
            requireContext()
        )
    }

    private fun setupUi() {
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
        adapter.onItemClickListener(object : AdapterCoins.onItemClickListener {
            override fun onItemClick(position: Int) {
                Helpers.ToastText("Item clicado: $position", requireContext())

                replaceFragment(InfoFragment())
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupSearchView(listResponse)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_fragment, fragment)
        fragmentTransaction?.commit()
    }

}