package com.example.balaklavafinances.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlin.time.Clock
import kotlin.time.Instant

enum class CategoryType (value: String) {
    INCOME("income"),
    EXPENSE("expense"),
}
@Entity("categories")
@TypeConverters(CategoryTypeConverter::class)
data class CategoriesEntity(
    @PrimaryKey val id: Long,
    val name: String,
    var type: CategoryType,
    val createdAt: Instant = Clock.System.now(),
    val updatedAt: Instant = Clock.System.now(),
    val deletedAt: Instant? = null,
)

@ProvidedTypeConverter
class CategoryTypeConverter {
    @TypeConverter
    fun toCategoryType(value: String): CategoryType = when (value) {
        CategoryType.INCOME.name -> CategoryType.INCOME
        CategoryType.EXPENSE.name -> CategoryType.EXPENSE
        else -> throw IllegalArgumentException("Invalid category type: $value")
    }

    @TypeConverter
    fun fromCategoryType(value: CategoryType): String = value.name
}
