package com.saadahmedsoft.e_commerce_assignment.services.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Database.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var bitmap: String = "",
    var name: String = "",
    var category: String = "",
    var price: String = "",
    var description: String = "",
    var isFavorite: Boolean = false
)
