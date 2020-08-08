package com.sanket.androidjetpack.network

/**
 * Created by Sanket on 07/08/20.
 */
class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}