package com.nuclearsunrise.uscishippo.apiutils

import android.content.Context
import android.net.ConnectivityManager

object Networkutils {
    private lateinit var myContext: Context

    fun isNetworkConnected(): Boolean {
        val connectivityManager = myContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }


    operator fun invoke(context: Context): Networkutils {
        this.myContext = context
        return this
    }
}