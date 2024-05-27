package com.example.appposters.core.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("body")
    var body: String,
    var url: String = ""
) {
    companion object {
        fun fromJson(json: String): PostModel {
            val data = Gson().fromJson(json, PostModel::class.java)
            // add because api can't return urlImage
            return data.copy(url = "https://picsum.photos/id/${data.id}/300/500")
        }
    }
}


