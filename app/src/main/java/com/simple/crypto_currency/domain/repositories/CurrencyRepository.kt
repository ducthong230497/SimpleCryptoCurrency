package com.simple.crypto_currency.domain.repositories

import com.simple.crypto_currency.domain.entities.CurrencyInfo
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getListCurrency(isAsc: Boolean): Flow<List<CurrencyInfo>>
}
