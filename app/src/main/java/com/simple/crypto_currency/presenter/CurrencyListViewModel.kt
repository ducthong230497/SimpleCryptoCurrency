package com.simple.crypto_currency.presenter

import androidx.lifecycle.*
import com.simple.crypto_currency.domain.use_cases.GetListCurrencyUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class CurrencyListViewModel(
    private val getListCurrencyUseCase: GetListCurrencyUseCase
) : ViewModel() {

    private var isAsc = true
    private val _sortDirection = MutableLiveData<Boolean>().apply { value = isAsc }
    val data = Transformations.switchMap(_sortDirection) {
        getListCurrencyUseCase.execute(isAsc).flowOn(Dispatchers.IO).distinctUntilChanged()
            .asLiveData(viewModelScope.coroutineContext)
    }

    fun reverseListData() {
        isAsc = !isAsc
        _sortDirection.value = isAsc
    }
}
