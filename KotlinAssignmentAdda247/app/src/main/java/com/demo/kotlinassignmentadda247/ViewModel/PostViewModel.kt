package com.demo.kotlinassignmentadda247.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.kotlinassignmentadda247.Model.ApiResponce

import com.demo.kotlinassignmentadda247.Repository.ApiRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel constructor(private val apiRepo: ApiRepo): ViewModel() {
    val userList= MutableLiveData<ApiResponce>()
    val errorMessage = MutableLiveData<String>()

    fun getData(){
        val responce = apiRepo.getUserData()
        responce.enqueue(object : Callback<ApiResponce>{
            override fun onResponse(call: Call<ApiResponce>, response: Response<ApiResponce>) {
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<ApiResponce>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}