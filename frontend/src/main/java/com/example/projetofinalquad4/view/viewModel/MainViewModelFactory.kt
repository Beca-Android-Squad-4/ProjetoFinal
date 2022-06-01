package com.example.projetofinalquad4.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nttdata.test.backend.data.repository.ICoinsRepository

class MainViewModelFactory(private val iCoinsRepository: ICoinsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(iCoinsRepository) as T
    }
}
