package com.saadahmedsoft.e_commerce_assignment.services.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Databse.TABLE_NAME

@Dao
interface ProductDao {
    @Query("SELECT * FROM $TABLE_NAME ORDER BY id ASC")
    fun getProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM $TABLE_NAME WHERE isFavorite ORDER BY id DESC")
    fun getFavorites(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Query("DELETE FROM $TABLE_NAME WHERE id=:id")
    fun deleteProduct(id: Int)
}