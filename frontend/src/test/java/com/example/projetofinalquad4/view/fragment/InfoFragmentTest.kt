package com.example.projetofinalquad4.view.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projetofinalquad4.test_utils.MainCoroutineRule
import com.example.projetofinalquad4.test_utils.getOrAwaitValue
import com.example.projetofinalquad4.view.viewModel.ICoinsClientFake
import com.example.projetofinalquad4.view.viewModel.MainViewModel
import com.example.projetofinalquad4.view.viewModel.mockCoinItem
import com.nttdata.test.backend.data.repository.CoinsRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InfoFragmentTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var mainViewModel: MainViewModel
    lateinit var mainViewModelError: MainViewModel

    @Before
    fun setup() {
        mainViewModel = MainViewModel(
            CoinsRepository(
                ICoinsClientFake("OK-200")
            )
        )
        mainViewModel.setCoin("BTC")

        mainViewModelError = MainViewModel(
            CoinsRepository(
                ICoinsClientFake("ERRO-Generic")
            )
        )
    }

    @Test
    fun `When selected coin is the same`() {
        val expectedCoin = mockCoinItem[0].asset_id // Bitcoin

        Assert.assertSame(expectedCoin, mainViewModel.coinSelected.getOrAwaitValue().asset_id)
    }

    @Test
    fun `When selected coin recive other`() {
        val expectedCoin = "Neymar"

        Assert.assertNotSame(expectedCoin, mainViewModel.coinSelected.getOrAwaitValue().asset_id)
    }

}
