package com.sanket.androidjetpack.utils

import com.sanket.androidjetpack.utils.Status.*

/**
 * Created by Sanket on 06/08/20.
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T? = null, message: String?): Resource<T> = Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T? = null): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }

}