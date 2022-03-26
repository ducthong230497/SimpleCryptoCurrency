package com.simple.crypto_currency.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.simple.crypto_currency.data.entities.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(obj: List<CurrencyEntity>): Array<Long>

    @Query("SELECT * FROM Currency ORDER BY CASE WHEN :isAsc = 1 THEN name END ASC, CASE WHEN :isAsc = 0 THEN name END DESC")
    abstract fun getListCurrency(isAsc: Int): Flow<List<CurrencyEntity>>
}
