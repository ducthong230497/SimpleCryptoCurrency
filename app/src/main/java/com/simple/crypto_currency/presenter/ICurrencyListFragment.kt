package com.simple.crypto_currency.presenter

import android.view.View
import com.simple.crypto_currency.domain.entities.CurrencyInfo
import java.io.Serializable

interface ICurrencyListFragment: Serializable {
    fun onItemClick(view: View, currencyInfo: CurrencyInfo)
}
