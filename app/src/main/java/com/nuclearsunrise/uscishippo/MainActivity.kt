package com.nuclearsunrise.uscishippo

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.nuclearsunrise.uscishippo.apiutils.APIhandler
import com.nuclearsunrise.uscishippo.apiutils.Networkutils

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { xview ->
            callAPItest(this.cacheDir)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setMainText(textString: String) {
        maintextview.setText(textString)
    }

    private fun callAPItest(cDir: File) {


        GlobalScope.launch(Dispatchers.IO)
        {
         try {
             val response = APIhandler(cDir).apiInterface.getFormsAsync().await()
             if (response.isSuccessful) {
                 Log.d("MainActivity", response.body()?.message)
                 val returnString = response.body()?.message
                 if (returnString is String) {
                     withContext(Dispatchers.Main)
                     {
                         setMainText(returnString as String)
                     }
                 } else {
                     withContext(Dispatchers.Main)
                     {
                         setMainText("Something failed")
                     }
                 }
             } else {
                 Log.d("MainActivity", "failure")
                 withContext(Dispatchers.Main)
                 {
                     setMainText("failed")
                 }
             }
         } catch (e: HttpException)
         {
             Log.d("MainActiivty", "Error: ${e.message}")
             withContext(Dispatchers.Main)
             {
                 setMainText("failed")
             }
         } catch (e: Throwable)
         {
             Log.d("MainActiivty", "Error: ${e.message}")
             withContext(Dispatchers.Main)
             {
                 setMainText("failed")
             }

         }
        }
    }
}
