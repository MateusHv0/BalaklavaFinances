package com.example.balaklavafinances.repositories

import androidx.room.Dao
import androidx.room.Query
import com.example.balaklavafinances.entities.ExpensesEntity

@Dao
interface ExpensesDao {
    @Query("SELECT * FROM expenses")
    suspend fun find(): List<ExpensesEntity>
}

class ExpensesRepository(private val expensesDao: ExpensesDao) {
   suspend fun find(): List<ExpensesEntity> {
        return expensesDao.find()
    }
}