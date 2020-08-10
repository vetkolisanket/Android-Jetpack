package com.sanket.androidjetpack.data_source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.sanket.androidjetpack.models.daos.Answer
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Sanket on 10/08/20.
 */
class AnswerDataSourceFactory(private val scope: CoroutineScope): DataSource.Factory<Int, Answer>() {

    val answerLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Answer>>()

    override fun create(): DataSource<Int, Answer> {
        val answerDataSource = AnswerDataSource(scope)
        answerLiveDataSource.postValue(answerDataSource)
        return answerDataSource
    }
}