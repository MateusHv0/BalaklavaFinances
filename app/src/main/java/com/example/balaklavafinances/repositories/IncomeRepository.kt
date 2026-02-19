package com.example.balaklavafinances.repositories

import androidx.room.Dao
import androidx.room.Query
import com.example.balaklavafinances.entities.IncomeEntity

@Dao
interface IncomeDao {
    @Query("SELECT * FROM income")
    suspend fun find(): List<IncomeEntity>
}

class IncomeRepository(private val incomeDao: IncomeDao) {
   suspend fun find(): List<IncomeEntity> {
        return incomeDao.find()
    }
}