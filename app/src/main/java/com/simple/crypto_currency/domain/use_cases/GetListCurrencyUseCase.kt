package com.simple.crypto_currency.domain.use_cases

import com.simple.crypto_currency.domain.entities.CurrencyInfo
import com.simple.crypto_currency.domain.repositories.CurrencyRepository
import kotlinx.coroutines.flow.Flow

interface GetListCurrencyUseCase {
    fun execute(isAsc: Boolean): Flow<List<CurrencyInfo>>
}

class GetListCurrencyUseCaseImpl(
    private val currencyRepository: CurrencyRepository
): GetListCurrencyUseCase {
    override fun execute(isAsc: Boolean): Flow<List<CurrencyInfo>> {
        return currencyRepository.getListCurrency(isAsc)
    }
}
