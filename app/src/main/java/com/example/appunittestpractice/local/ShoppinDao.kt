package com.example.appunittestpractice.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appunittestpractice.model.ShoppingItem

@Dao
interface ShoppinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppinItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun observerAllShoppingItem():LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price*amount) FROM shopping_item")
    fun observeTotalPrice():LiveData<Float>
}