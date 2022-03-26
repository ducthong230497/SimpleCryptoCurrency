package com.simple.crypto_currency.app

import android.content.Context
import androidx.startup.Initializer
import com.simple.crypto_currency._di.databaseModule
import com.simple.crypto_currency._di.domainModule
import com.simple.crypto_currency._di.presenterModule
import com.simple.crypto_currency._di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class AppInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        startKoin {
            androidContext(context)
            val moduleList = ArrayList<Module>()
            moduleList.addAll(
                listOf(
                    databaseModule,
                    repositoryModule,
                    domainModule,
                    presenterModule
                )
            )
            modules(moduleList)
        }
    }

    override fun dependencies() = emptyList<Class<out Initializer<*>>>()

}
