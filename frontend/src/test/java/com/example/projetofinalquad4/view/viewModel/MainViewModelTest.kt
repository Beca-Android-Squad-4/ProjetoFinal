package com.example.projetofinalquad4.view.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projetofinalquad4.test_utils.MainCoroutineRule
import com.example.projetofinalquad4.test_utils.getOrAwaitValue
import com.nttdata.test.backend.data.remote.dto.CoinApiResult
import com.nttdata.test.backend.data.repository.CoinsRepository
import io.mockk.InternalPlatformDsl.toArray
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var mainViewModelOk: MainViewModel
    lateinit var mainViewModelError: MainViewModel

    @Before
    fun setup() {
        mainViewModelOk = MainViewModel(
            CoinsRepository(
                ICoinsClientFake("OK-200")
            )
        )
        mainViewModelError = MainViewModel(
            CoinsRepository(
                ICoinsClientFake("ERRO-Generic")
            )
        )
    }

    @Test
    fun `When api call is successful`() {
        // TODO
        Assert.assertEquals(true, true)
    }

    @Test
    fun `When api call is fail`() {
        // TODO
        Assert.assertEquals(true, true)
    }

    @Test
    fun `Set ID of _coinSelected and return the same ID in coinSelected`() {
        // Given
        val id = "BTC"

        // Then
        mainViewModelOk.setCoin(id)
        val result = mainViewModelOk.coinSelected.getOrAwaitValue().asset_id

        // When
        Assert.assertEquals(id, result)
    }

    @Test
    fun `When the list of coins isn't empty, not require other api call`() {
        // Given
        val list = mainViewModelOk.coinItem
        var result = true
        var result2 = true

        // Then
        mainViewModelOk.getCoinsFromRetrofit()
        when (list) {
            is CoinApiResult.Success<*> -> {
                result = list.getOrAwaitValue().toArray().isEmpty() // Return False
            }
        }

        mainViewModelOk.getCoinsFromRetrofit()

        when (mainViewModelOk.coinItem) {
            is CoinApiResult.Success<*> -> {
                result2 = list.getOrAwaitValue().toArray().isEmpty() // Return False
            }
        }

        // When
        Assert.assertEquals(result, result2)
    }

    @Test
    fun `When setFavorite set true`() {
        // Given
        val btc = mockCoinItem[0]
        btc.isFavorite = true // Is favorite

        // When
        mainViewModelOk.getCoinsFromRetrofit()
        mainViewModelOk.setCoin("BTC")
        mainViewModelOk.setFavorite(true)

        // Then

        Assert.assertEquals(
            btc.isFavorite,
            mainViewModelOk.coinSelected.getOrAwaitValue().isFavorite
        )
    }

    @Test
    fun `When setFavorite set false`() {
        // Given
        val btc = mockCoinItem[0]
        btc.isFavorite = false // Is favorite

        // When
        mainViewModelOk.getCoinsFromRetrofit()
        mainViewModelOk.setCoin("BTC")
        mainViewModelOk.setFavorite(false)

        // Then

        Assert.assertEquals(
            btc.isFavorite,
            mainViewModelOk.coinSelected.getOrAwaitValue().isFavorite
        )
    }

    @Test
    fun `When getOnlyCryptos return only cryptos`() {
        val listTest = mockCoinItem.filter { it.type_is_crypto == 1 }

        val result = mainViewModelOk.getOnlyCrypto(mockCoinItem)

        Assert.assertEquals(listTest, result)
    }
}
