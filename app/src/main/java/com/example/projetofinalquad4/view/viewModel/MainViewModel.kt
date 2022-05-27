package com.example.projetofinalquad4.view.viewModel

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
    // Essa é a moeda escolhida no CoinsFragment que será utilizada no InfoFragment
    private val _coinSelected = MutableLiveData<CoinItem>()
    val coinSelected: LiveData<CoinItem> = _coinSelected

    private val _coinsItem = MutableLiveData<List<CoinItem>>()
    val coinItem: LiveData<List<CoinItem>> = _coinsItem

    fun setCoin(coinId: String) {
        viewModelScope.launch {
            _coinSelected.value = coinItem.value?.find { it.asset_id == coinId }
        }
    }

    fun getCoinsFromRetrofit() {
        viewModelScope.launch {
            if (_coinsItem.value.isNullOrEmpty()) {
                var result = iCoinsRepository.getCoins()
                _coinsItem.value = setIconUrl(getOnlyCrypto(result))
            }
        }
    }

    fun setFavorite(isFavorite: Boolean) {
        viewModelScope.launch {
            _coinSelected.value?.isFavorite = isFavorite
        }
    }

    private fun getOnlyCrypto(list: List<CoinItem>): List<CoinItem> {
        return list.filter { it.type_is_crypto == Constants.TYPE_IS_CRYPTO }
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
