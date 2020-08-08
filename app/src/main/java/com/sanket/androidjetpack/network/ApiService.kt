package com.sanket.androidjetpack.network

import com.sanket.androidjetpack.models.User
import retrofit2.http.GET

/**
 * Created by Sanket on 07/08/20.
 */
interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}