package com.saadahmedsoft.e_commerce_assignment.services.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saadahmedsoft.e_commerce_assignment.services.dao.ProductDao
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Database.TABLE_NAME

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun applicationDao(): ProductDao

    companion object {
        @Volatile
        var instance: ProductDatabase? = null

        fun getDatabaseInstance(context: Context): ProductDatabase {
            val tempInstance = instance

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val roomDatabaseInstance = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    TABLE_NAME
                ).allowMainThreadQueries().build()
                instance = roomDatabaseInstance
                return instance as ProductDatabase
            }
        }
    }
}