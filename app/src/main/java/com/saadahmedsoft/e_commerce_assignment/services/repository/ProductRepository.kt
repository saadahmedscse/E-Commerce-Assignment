package com.saadahmedsoft.e_commerce_assignment.services.repository

import androidx.lifecycle.LiveData
import com.saadahmedsoft.e_commerce_assignment.services.dao.ProductDao
import com.saadahmedsoft.e_commerce_assignment.services.model.Product

class ProductRepository(private val dao: ProductDao) {

    fun getProducts(): LiveData<List<Product>> = dao.getProducts()

    fun getFavorites(): LiveData<List<Product>> = dao.getFavorites()

    fun insertProduct(product: Product) {
        dao.insertProduct(product)
    }

    fun updateProduct(product: Product) {
        dao.updateProduct(product)
    }

    fun deleteProduct(id: Int) {
        dao.deleteProduct(id)
    }
}