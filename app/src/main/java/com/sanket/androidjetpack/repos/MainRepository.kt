package com.sanket.androidjetpack.repos

import com.sanket.androidjetpack.network.ApiHelper

/**
 * Created by Sanket on 07/08/20.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getAnswers(page: Int, pageSize: Int, site: String) = apiHelper.getAnswers(page, pageSize, site)

}