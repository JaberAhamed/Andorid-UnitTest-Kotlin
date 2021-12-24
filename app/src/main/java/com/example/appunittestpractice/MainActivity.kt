package com.example.appunittestpractice

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.appunittestpractice.genericConcept.Event
import com.example.appunittestpractice.genericConcept.Resource
import com.example.appunittestpractice.model.ShoppingItem
import com.example.appunittestpractice.simpleUserRegistration.HomeWork

class MainActivity : AppCompatActivity() {

    private val _images = MutableLiveData<Event<Resource<ShoppingItem>>>()
    var images: LiveData<Event<Resource<ShoppingItem>>> = _images
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("FABONACCI",HomeWork.fib(6).toString())

        var normalgen = Event("474")
        val aString = "42"
        var normalGeneric_one = Event(45)
        var normalGeneric_on = Event(45.5)
        var shoppingItem = ShoppingItem("anem", 2, 2.0F, "URL", 1)
        _images.value = Event(Resource.success(shoppingItem))
        images = _images

         images.observe(this, Observer { item->
           var shoppingItem =   item.getContentIfNotHandled()?.data

         })




    }
}