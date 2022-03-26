package com.simple.crypto_currency._di

import com.simple.crypto_currency.data.database.AppDatabase
import com.simple.crypto_currency.data.repositories_impl.CurrencyRepositoryImpl
import com.simple.crypto_currency.domain.repositories.CurrencyRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single(createdAtStart = true) { AppDatabase.getDatabase(androidContext()) }
    single { get<AppDatabase>().currencyDao() }
}

val repositoryModule = module {
    single<CurrencyRepository> { CurrencyRepositoryImpl(currencyDao = get()) }
}
