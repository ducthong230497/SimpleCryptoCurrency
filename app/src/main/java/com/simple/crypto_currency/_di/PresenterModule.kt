package com.simple.crypto_currency._di

import com.simple.crypto_currency.presenter.CurrencyListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel { CurrencyListViewModel(getListCurrencyUseCase = get()) }
}
