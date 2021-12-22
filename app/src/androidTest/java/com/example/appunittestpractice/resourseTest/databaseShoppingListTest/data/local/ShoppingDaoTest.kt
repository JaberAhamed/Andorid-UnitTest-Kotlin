package com.example.appunittestpractice.resourseTest.databaseShoppingListTest.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.appunittestpractice.local.ShoppinDao
import com.example.appunittestpractice.local.ShoppinItemDatabase
import com.example.appunittestpractice.model.ShoppingItem
import com.google.common.truth.Truth.assertThat
import getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    lateinit var shoppinItemDatabase: ShoppinItemDatabase
    lateinit var dao: ShoppinDao

    @Before
    fun setUp() {
        shoppinItemDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppinItemDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = shoppinItemDatabase.shoppingDao()
    }

    @After
    fun tearDowon() {
        shoppinItemDatabase.close()
    }


    @Test
    fun insertShoppingItem() = runBlockingTest {

        var shoppingItem = ShoppingItem("anem", 2, 2.0F, "URL", 1)
        dao.insertShoppinItem(shoppingItem)
        val shoppintlist = dao.observerAllShoppingItem().getOrAwaitValue()
        assertThat(shoppintlist).contains(shoppingItem)

    }

    @Test
    fun deleteShoppintItem() = runBlockingTest {

        var shoppingItem = ShoppingItem("anem", 2, 2.0F, "URL", 1)
        dao.insertShoppinItem(shoppingItem)
        dao.deleteItem(shoppingItem)
        val shoppintlist = dao.observerAllShoppingItem().getOrAwaitValue()
        assertThat(shoppintlist).doesNotContain(shoppingItem)

    }

    @Test
    fun totlaPriceCount() = runBlockingTest {

        var shoppingItem1 = ShoppingItem("anem", 2, 3.0F, "URL", 1)
        var shoppingItem2 = ShoppingItem("anem", 2, 2.0F, "URL", 2)
        var shoppingItem3 = ShoppingItem("anem", 2, 5.0F, "URL", 3)

        dao.insertShoppinItem(shoppingItem1)
        dao.insertShoppinItem(shoppingItem2)
        dao.insertShoppinItem(shoppingItem3)

        val totalSum = dao.observeTotalPrice().getOrAwaitValue()
        assertThat(totalSum).isEqualTo(2*3.0F+2*2.0F+2*5.0F)

    }
}