package com.demo.kotlinassignmentadda247.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.kotlinassignmentadda247.Repository.ApiRepo

class PostViewModelFactory constructor(private val repository: ApiRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            PostViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}