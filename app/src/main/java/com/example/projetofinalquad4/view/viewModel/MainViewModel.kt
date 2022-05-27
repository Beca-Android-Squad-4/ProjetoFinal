package com.example.projetofinalquad4.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import com.example.projetofinalquad4.data.repository.ICoinsRepository
import com.example.projetofinalquad4.utils.Constants
import kotlinx.coroutines.launch

class MainViewModel(
    private val iCoinsRepository: ICoinsRepository
) : ViewModel() {
    // Pass Coin between fragments
    private val _coinsDto = MutableLiveData<String>()
    val coinDtoId: LiveData<String> = _coinsDto

    private val _coinsItem = MutableLiveData<List<CoinItem>>()
    val coinItem: LiveData<List<CoinItem>> = _coinsItem

    fun SetListCoins(coinId: String) {
        viewModelScope.launch {
            _coinsDto.value = coinId
            Log.d("CoinSet", "onActivityCreated: $coinDtoId")
        }
    }

    fun getCoinsFromRetrofit() {
        viewModelScope.launch {
            var result = iCoinsRepository.getCoins()
            Log.d("responseRetrofit", "getData: $result")

            _coinsItem.value = setIconUrl(result)
        }
    }

    private fun setIconUrl(list: List<CoinItem>): List<CoinItem> {
        list.forEach { coin ->
            if (coin.id_icon != null) {
                coin.icon_url = Constants.ICON_URL_BASE +
                    coin.id_icon.replace("-", "") +
                    Constants.ICON_DEFAULT_TYPE
            }
        }
        return list
    }
}
