package com.sanket.androidjetpack.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanket.androidjetpack.network.ApiHelper
import com.sanket.androidjetpack.repos.MainRepository
import java.lang.IllegalArgumentException

/**
 * Created by Sanket on 07/08/20.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}