package com.sanket.androidjetpack.models.dtos.response

import com.google.gson.annotations.SerializedName
import com.sanket.androidjetpack.models.daos.Answer

/**
 * Created by Sanket on 09/08/20.
 */
data class StackExchangeApiResponseDto (

    @SerializedName("items")
    val answers: List<Answer>,

    @SerializedName("has_more")
    val hasMore: Boolean,

    @SerializedName("quota_max")
    val quotaMax: Int,

    @SerializedName("quota_remaining")
    val quotaRemaining: Int

) {


}