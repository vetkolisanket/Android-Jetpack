package com.sanket.androidjetpack.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.androidjetpack.repos.MainRepository
import com.sanket.androidjetpack.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Sanket on 07/08/20.
 */
class HomeViewModel(private val mainRepository: MainRepository) : ViewModel() {

    companion object {
        private const val PAGE = 1
        private const val PAGE_SIZE = 10
        private const val SITE = "stackoverflow"
    }

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val responseDto = mainRepository.getAnswers(PAGE, PAGE_SIZE, SITE)
            emit(Resource.success(data = responseDto.answers))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}