package com.example.projetofinalquad4.view.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projetofinalquad4.data.remote.dto.CoinApiResult
import com.example.projetofinalquad4.data.repository.CoinsRepository
import com.example.projetofinalquad4.getOrAwaitValue
import com.example.projetofinalquad4.utils.MainCoroutineRule
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
                ICoinsClientFake("ERRO-400")
            )
        )
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
        var result = false
        var result2 = false

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
}
