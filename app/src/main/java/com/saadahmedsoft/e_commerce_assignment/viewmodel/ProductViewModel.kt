package com.saadahmedsoft.e_commerce_assignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.saadahmedsoft.e_commerce_assignment.services.database.ProductDatabase
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.services.repository.ProductRepository

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    init {
        val dao = ProductDatabase.getDatabaseInstance(application).applicationDao()
        repository = ProductRepository(dao)
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun updateProduct(product: Product) {
        repository.updateProduct(product)
    }

    fun getProducts(): LiveData<List<Product>> {
        return repository.getProducts()
    }

    fun deleteProduct(id: Int) {
        return repository.deleteProduct(id)
    }
}