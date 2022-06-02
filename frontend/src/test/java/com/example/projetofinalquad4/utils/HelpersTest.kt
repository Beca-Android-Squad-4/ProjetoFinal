package com.example.projetofinalquad4.utils

import com.example.projetofinalquad4.view.viewModel.mockCoinItem
import com.nttdata.test.backend.data.remote.dto.CoinItem
import org.junit.Assert
import org.junit.Test

class HelpersTest {

    @Test
    fun `Filter query list is successful`() {
        // Given
        val list = mockCoinItem
        val expectedList = mockCoinItem[0] // Bitcoin

        // When
        val result = Helpers.FilterListQuery("Bit", list)[0]

        // Them
        Assert.assertSame(expectedList, result)
    }

    @Test
    fun `When filterQueryList return a empty list`() {
        // Given
        val list = mockCoinItem
        val expectedList = emptyList<CoinItem>()

        // When
        val result = Helpers.FilterListQuery("Neymar", list) // No have coin "Neymar" in mockCoinList

        // Them
        Assert.assertSame(expectedList.size, result.size)
    }
}
