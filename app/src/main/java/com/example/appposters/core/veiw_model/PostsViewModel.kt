package com.example.appposters.core.veiw_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appposters.core.models.PostModel
import com.example.appposters.core.repository.PostRepository
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val _repository = PostRepository()

    private var _posts = MutableLiveData<List<PostModel>>()

    val posts: LiveData<List<PostModel>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val result = _repository.getPosts()
                _posts.value = result
            } catch (e: Exception) {
                print("TAG-[POST-ERROR] ${e.message}")
            }
        }
    }


}