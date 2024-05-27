package com.example.appposters.core.veiw_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appposters.core.models.PostModel
import com.example.appposters.core.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val _repository = PostRepository()


    private var _posts = MutableStateFlow(emptyList<PostModel>())

    val posts = _posts.asStateFlow()

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