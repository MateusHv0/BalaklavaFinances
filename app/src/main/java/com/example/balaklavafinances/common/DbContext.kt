package com.example.balaklavafinances.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.balaklavafinances.entities.CategoriesEntity
import com.example.balaklavafinances.entities.ExpensesEntity
import com.example.balaklavafinances.entities.IncomeEntity
import com.example.balaklavafinances.repositories.CategoriesDao
import com.example.balaklavafinances.repositories.ExpensesDao
import com.example.balaklavafinances.repositories.IncomeDao

@Database(
    entities = [
        CategoriesEntity::class,
        IncomeEntity::class,
        ExpensesEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun incomeDao(): IncomeDao
    abstract fun expensesDao(): ExpensesDao

    /**
     * Singleton to avoid having multiple instances of the database
     */
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            /**
             * Uses synchronized to avoid having multiple threads opening the database, locking the companion object to be executed multiple times
             */
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "balaklava_finances"
                ).build()

                instance = newInstance
                return newInstance
            }
        }
    }
}