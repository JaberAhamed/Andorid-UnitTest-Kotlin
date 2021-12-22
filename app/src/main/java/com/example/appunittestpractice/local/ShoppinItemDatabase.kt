package com.example.appunittestpractice.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appunittestpractice.model.ShoppingItem

@Database(entities = [ShoppingItem::class],
version = 1)
abstract class ShoppinItemDatabase : RoomDatabase() {
    abstract fun shoppingDao():ShoppinDao
}