package com.example.appposters.core.models

import com.google.gson.annotations.SerializedName

class PostModel(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("body")
    var body: String,
    val url: String = "https://www.alucare.fr/wp-content/uploads/2023/08/Naruto-scaled.jpg"
)


