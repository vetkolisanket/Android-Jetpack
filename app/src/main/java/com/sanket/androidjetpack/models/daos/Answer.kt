package com.sanket.androidjetpack.models.daos

import com.google.gson.annotations.SerializedName

data class Answer(

    @SerializedName("owner")
    val owner: Owner,

    @SerializedName("is_accepted")
    val isAccepted: Boolean,

    @SerializedName("score")
    val score: Int,

    @SerializedName("last_activity_date")
    val lastActivityDate: Long,

    @SerializedName("creation_date")
    val creationDate: Long,

    @SerializedName("answer_id")
    val answerId: Long,

    @SerializedName("question_id")
    val questionId: Long

) {

    data class Owner(

        @SerializedName("reputation")
        val reputation: Int,

        @SerializedName("user_id")
        val userId: Long,

        @SerializedName("user_type")
        val userType: String,

        @SerializedName("profile_image")
        val profileImage: String,

        @SerializedName("display_name")
        val displayName: String,

        @SerializedName("link")
        val link: String

    )


}