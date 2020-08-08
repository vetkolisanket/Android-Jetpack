package com.sanket.androidjetpack.repos

import com.sanket.androidjetpack.network.ApiHelper

/**
 * Created by Sanket on 07/08/20.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}