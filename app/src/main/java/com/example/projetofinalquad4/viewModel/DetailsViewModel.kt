package com.example.projetofinalquad4.viewModel


import androidx.lifecycle.*
import com.example.projetofinalquad4.data.remote.dto.CoinApiResult
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import com.example.projetofinalquad4.data.repository.CoinRepostitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DetailsViewModel (private val coinRepostitory: CoinRepostitory) : ViewModel() {
    private val _coins = MutableLiveData<CoinApiResult<List<CoinDto>>>()
    val coins: LiveData<CoinApiResult<List<CoinDto>>> = _coins

    fun getCoinsFromRetrofit(){
        viewModelScope.launch {
            _coins.value = CoinApiResult.Loading()
            try {
                val coinsFromApi = withContext(Dispatchers.IO){
                    coinRepostitory.getcoins()
                }

                _coins.value = CoinApiResult.Success(coinsFromApi)
            } catch (e:Exception){
                val coinResult = CoinApiResult.Error<List<CoinDto>>(e)
            }
        }
    }
}

class CoinViewModelFactory(private val repostitory: CoinRepostitory): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(repostitory)as T
    }
}
