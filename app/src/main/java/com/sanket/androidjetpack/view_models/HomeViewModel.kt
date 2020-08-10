package com.sanket.androidjetpack.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.sanket.androidjetpack.data_source.AnswerDataSource
import com.sanket.androidjetpack.data_source.AnswerDataSourceFactory
import com.sanket.androidjetpack.models.daos.Answer
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

    val answerPagedList: LiveData<PagedList<Answer>>
    private val liveDataSource: LiveData<PageKeyedDataSource<Int, Answer>>

    init {
        val answerDataSourceFactory = AnswerDataSourceFactory(viewModelScope)
        liveDataSource = answerDataSourceFactory.answerLiveDataSource
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(AnswerDataSource.PAGE_SIZE)
            .build()
        answerPagedList = LivePagedListBuilder(answerDataSourceFactory, config).build()
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