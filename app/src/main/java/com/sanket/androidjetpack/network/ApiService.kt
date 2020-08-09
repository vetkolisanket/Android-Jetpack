package com.sanket.androidjetpack.network

import com.sanket.androidjetpack.models.User
import com.sanket.androidjetpack.models.dtos.response.StackExchangeApiResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sanket on 07/08/20.
 */
interface ApiService {

    @GET("answers")
    suspend fun getAnswers(
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int,
        @Query("site") site: String
    ): StackExchangeApiResponseDto

}