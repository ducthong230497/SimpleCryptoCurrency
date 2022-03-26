package com.simple.crypto_currency._di

import com.simple.crypto_currency.domain.use_cases.GetListCurrencyUseCase
import com.simple.crypto_currency.domain.use_cases.GetListCurrencyUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetListCurrencyUseCase> { GetListCurrencyUseCaseImpl(currencyRepository = get()) }
}
