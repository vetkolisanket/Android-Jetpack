package com.sanket.androidjetpack.data_source

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.sanket.androidjetpack.models.daos.Answer
import com.sanket.androidjetpack.network.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Sanket on 10/08/20.
 */
class AnswerDataSource: PageKeyedDataSource<Int, Answer>() {


    companion object {
        private const val FIRST_PAGE = 1
        const val PAGE_SIZE = 10
        private const val SITE = "stackoverflow"
        private const val TAG: String = "AnswerDataSource"
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Answer>) {
        GlobalScope.launch {
            try {
                val answers = RetrofitBuilder.apiService.getAnswers(FIRST_PAGE, PAGE_SIZE, SITE)
                callback.onResult(answers.answers, null, FIRST_PAGE + 1)
            } catch (exception: Exception) {
                Log.d(TAG, "loadInitial: $exception")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Answer>) {
        GlobalScope.launch {
            val answers = RetrofitBuilder.apiService.getAnswers(params.key, PAGE_SIZE, SITE)
            val adjacentPageKey = if (answers.hasMore) {
                params.key + 1
            } else {
                null
            }
            callback.onResult(answers.answers, adjacentPageKey)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Answer>) {
        GlobalScope.launch {
            val answers = RetrofitBuilder.apiService.getAnswers(params.key, PAGE_SIZE, SITE)
            val adjacentPageKey = if (params.key > 1) {
                params.key - 1
            } else {
                null
            }
            callback.onResult(answers.answers, adjacentPageKey)
        }
    }
}