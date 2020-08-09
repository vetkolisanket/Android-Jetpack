package com.sanket.androidjetpack.network

/**
 * Created by Sanket on 07/08/20.
 */
class ApiHelper(private val apiService: ApiService) {
    suspend fun getAnswers(page: Int, pageSize: Int, site: String) = apiService.getAnswers(page, pageSize, site)
}