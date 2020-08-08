package com.sanket.androidjetpack.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.androidjetpack.repos.MainRepository
import com.sanket.androidjetpack.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Sanket on 07/08/20.
 */
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}