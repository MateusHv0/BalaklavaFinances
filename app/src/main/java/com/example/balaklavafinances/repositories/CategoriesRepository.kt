package com.example.balaklavafinances.repositories

import androidx.room.Dao
import androidx.room.Query
import com.example.balaklavafinances.entities.CategoriesEntity

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories")
    suspend fun find(): List<CategoriesEntity>
}

class CategoriesRepository(private val categoriesDao: CategoriesDao) {
   suspend fun find(): List<CategoriesEntity> {
        return categoriesDao.find()
    }
}