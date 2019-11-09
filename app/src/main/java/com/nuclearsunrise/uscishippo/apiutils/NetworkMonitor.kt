package com.nuclearsunrise.uscishippo.apiutils

import android.net.ConnectivityManager
import android.net.Network

class NetworkMonitor(private val connectivityManager: ConnectivityManager ) {
    private var callbackFun: ((Boolean) -> Unit) = { isConnected = it }

    private var isConnected: Boolean = false

    init
    {
        this.startListener(callbackFun)
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network?) {
            super.onAvailable(network)
            callbackFun(true)
        }

        override fun onLost(network: Network?) {
            super.onLost(network)
            callbackFun(false)
        }
    }

    private fun startListener(callback: (Boolean) -> Unit) {
        callbackFun = callback
        callbackFun(false)
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    fun stopListener() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
        callbackFun = {}
    }

    fun getStatus(): Boolean {
        return isConnected
    }
}