package com.example.projetofinalquad4.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.FragmentErrorBinding
import com.example.projetofinalquad4.utils.Helpers
import com.example.projetofinalquad4.view.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_error.view.*

class ErrorFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels() { Helpers.getMainViewModelFactory() }
    private var _binding: FragmentErrorBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentErrorBinding.inflate(inflater, container, false)
        mensagemErro()
        binding.btnTryAgain.setOnClickListener {
            replaceFragment(CoinsFragment())
        }

        val view = binding.root
        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_fragment, fragment)
        fragmentTransaction?.commit()
    }

    private fun mensagemErro() {
        val mensagem = viewModel.setErro()
        binding.mensagem.text = mensagem
    }
}

private fun Button.setOnClickListener(replaceFragment: Unit) {
}
