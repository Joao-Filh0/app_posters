package com.example.appposters.core.servicies

import com.example.appposters.core.models.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend  fun list(): List<PostModel>
}