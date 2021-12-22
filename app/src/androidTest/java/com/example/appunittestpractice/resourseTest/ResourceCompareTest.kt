package com.example.appunittestpractice.resourseTest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.appunittestpractice.R
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceCompareTest{
    lateinit var resourceCompare:ResourceCompare

    @Before
    fun setUp(){
        resourceCompare = ResourceCompare()
    }

    @After
    fun teardown(){}

    @Test
    fun stringResourceSameasGivingString_returnTrue(){

        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEquil(context, R.string.app_name,"AppUnitTestPractice")
        assertThat(result).isTrue()

    }



    @Test
    fun stringResourceSameasGivingString_returnFalse(){

        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEquil(context, R.string.app_name,"Hellow")
        assertThat(result).isFalse()

    }
}