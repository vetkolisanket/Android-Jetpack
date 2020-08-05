package com.sanket.androidjetpack.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.sanket.androidjetpack.Constants
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.get
import com.sanket.androidjetpack.put

class MainActivity : AppCompatActivity() {

    private val sharedPref by lazy { getSharedPreferences(Constants.PREF_NAME, Constants.PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun isUserLoggedIn() = sharedPref.get(Constants.IS_USER_LOGGED_IN, false)

    fun save(key: String, value: Boolean) {
        sharedPref.put(key, value)
    }
}
