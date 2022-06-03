package com.example.projetofinalquad4.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinalquad4.utils.Constants
import com.nttdata.test.backend.data.remote.dto.CoinApiResult
import com.nttdata.test.backend.data.remote.dto.CoinItem
import com.nttdata.test.backend.data.repository.ICoinsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel(
    private val iCoinsRepository: ICoinsRepository
) : ViewModel() {
    // Pass Coin between fragments
    // Essa é a moeda escolhida no CoinsFragment que será utilizada no InfoFragment
    private val _coinSelected = MutableLiveData<CoinItem>()

    // private val _coinSelected = MutableLiveData<CoinApiResult<List<CoinItem>>>()
    val coinSelected: LiveData<CoinItem> = _coinSelected
    // val coinSelected: LiveData<CoinApiResult<List<CoinItem>>> = _coinSelected

    // private val _coinsItem = MutableLiveData<List<CoinItem>>()
    private val _coinsItem = MutableLiveData<CoinApiResult<List<CoinItem>>>()

    // val coinItem: LiveData<List<CoinItem>> = _coinsItem
    val coinItem: LiveData<CoinApiResult<List<CoinItem>>> = _coinsItem

    var coinsFromApi: List<CoinItem> = ArrayList()

    // tratamento de erros
    var mensagem = ""

    fun setCoin(coinId: String) {
        viewModelScope.launch {
            _coinsItem.value = CoinApiResult.Loading()
            try {
                if (coinsFromApi.isNullOrEmpty()) {
                    coinsFromApi = withContext(Dispatchers.IO) {
                        iCoinsRepository.getCoins()
                    }
                    coinsFromApi = setIconUrl(coinsFromApi)
                    coinsFromApi = getOnlyCrypto(coinsFromApi)
                }
                _coinSelected.value = coinsFromApi.find { it.asset_id == coinId }
                _coinsItem.value = CoinApiResult.Success(coinsFromApi)
            } catch (e: Exception) {
                val coinResult = CoinApiResult.Error<List<CoinItem>>(e)
                _coinsItem.value = coinResult
            }
        }
    }

    fun getCoinsFromRetrofit() {
        viewModelScope.launch {
            _coinsItem.value = CoinApiResult.Loading()
            try {
                if (coinsFromApi.isNullOrEmpty()) {
                    coinsFromApi = withContext(Dispatchers.IO) {
                        iCoinsRepository.getCoins()
                    }
                    coinsFromApi = setIconUrl(coinsFromApi)
                    coinsFromApi = getOnlyCrypto(coinsFromApi)
                }
                _coinsItem.value = CoinApiResult.Success(coinsFromApi)
            } catch (e: Exception) {
                val coinResult = CoinApiResult.Error<List<CoinItem>>(e)
                Log.d("CoinResult", "setCoin: $coinResult")
                _coinsItem.value = coinResult
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
                    coin.id_icon!!.replace("-", "") +
                    Constants.ICON_DEFAULT_TYPE
            }
        }
        return list
    }
}
