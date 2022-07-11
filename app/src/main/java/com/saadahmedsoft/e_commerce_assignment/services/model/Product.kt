package com.saadahmedsoft.e_commerce_assignment.services.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Databse.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val bitmap: String = "",
    val name: String = "",
    val category: String = "",
    val price: String = "",
    val description: String = ""
)
