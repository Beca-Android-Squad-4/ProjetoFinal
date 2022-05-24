package com.example.projetofinalquad4.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _coinsDto = MutableLiveData<String>()
    val coinDtoId: LiveData<String> = _coinsDto

    fun SetListCoins(coinId: String) {
        viewModelScope.launch {
            _coinsDto.value = coinId
            Log.d("CoinSet", "onActivityCreated: $coinDtoId")
        }
    }
}
