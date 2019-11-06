package com.nuclearsunrise.uscishippo.apiutils

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nuclearsunrise.uscishippo.data.constants.Companion.STR_BASE_URL
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

object APIhandler {
    private lateinit var cacheDir: File

    val apiInterface: APIinterface by lazy {
        Log.d("APIhanlder", "Creating Client")

        if (cacheDir != null)
        {
            Log.d("APIhandler", "Cache Directory set")

            val cacheSize: Long = 5 * 1024 * 1024 // 5MB should be more than enough
            val cache = Cache(this.cacheDir, cacheSize)
            val okHttpClient = OkHttpClient.Builder()
                .cache(cache)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(STR_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return@lazy retrofit.create(APIinterface::class.java)


        }

        Log.d("APIhandler", "Cache Directory not set")
        val retrofit = Retrofit.Builder()
            .baseUrl(STR_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return@lazy retrofit.create(APIinterface::class.java)
    }

    operator fun invoke(cDir:File): APIhandler {
        this.cacheDir = cDir
        return this
    }
}