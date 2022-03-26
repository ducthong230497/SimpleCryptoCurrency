package com.simple.crypto_currency.data.repositories_impl

import com.simple.crypto_currency.data.daos.CurrencyDao
import com.simple.crypto_currency.domain.entities.CurrencyInfo
import com.simple.crypto_currency.domain.repositories.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CurrencyRepositoryImpl(
    private val currencyDao: CurrencyDao
): CurrencyRepository {
    override fun getListCurrency(isAsc: Boolean): Flow<List<CurrencyInfo>> {
        return currencyDao.getListCurrency(if (isAsc) 1 else 0).map {
            it.map { CurrencyInfo(it.id, it.name, it.symbol) }
        }
    }
}
