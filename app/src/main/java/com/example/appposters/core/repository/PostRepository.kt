package com.example.appposters.core.repository

import com.example.appposters.core.client_http.RetrofitClient
import com.example.appposters.core.models.PostModel
import com.example.appposters.core.servicies.PostService

class PostRepository {

    suspend fun getPosts(): List<PostModel> {
        return RetrofitClient.request(PostService::class.java).list()
    }
}