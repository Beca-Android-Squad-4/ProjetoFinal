package com.example.projetofinalquad4.data.repository

import com.example.projetofinalquad4.data.remote.dto.CoinDto

interface ICoinRepostitory {
    suspend fun getcoins(): List<CoinDto>
}