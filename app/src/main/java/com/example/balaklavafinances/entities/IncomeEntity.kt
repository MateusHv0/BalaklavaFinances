package com.example.balaklavafinances.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlin.time.Clock
import kotlin.time.Instant

@Entity("income")
data class IncomeEntity(
    @PrimaryKey val id: Long,
    val categoryId: Long,
    val description: String?,
    /**
     * Always in cents like $1.57 = 157
     */
    val amount: Long,
    val expenseDate: Instant = Clock.System.now(),
    val createdAt: Instant = Clock.System.now(),
    var updatedAt: Instant = Clock.System.now(),
    val deletedAt: Instant? = null,
)

data class IncomeAndCategoriesRelation(
    @Embedded val income: IncomeEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val categories: CategoriesEntity
)