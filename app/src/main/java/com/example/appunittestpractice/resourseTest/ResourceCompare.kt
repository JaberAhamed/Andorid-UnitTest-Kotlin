package com.example.appunittestpractice.resourseTest

import android.content.Context

class ResourceCompare {

    fun isEquil(context: Context,resourceId:Int,string: String):Boolean
    {
      return context.getString(resourceId) == string
    }

}