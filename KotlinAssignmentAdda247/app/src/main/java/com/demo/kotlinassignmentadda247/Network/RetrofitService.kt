package com.demo.kotlinassignmentadda247.Network

import com.demo.kotlinassignmentadda247.Model.ApiResponce
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    @GET("/public-api/users/")
    fun getData(): Call<ApiResponce>

    companion object{
        var retrofitService: RetrofitService?= null
        fun getInstance(): RetrofitService{

            if(retrofitService== null)
            {

              var retrofit=  Retrofit.Builder()
                    .baseUrl("https://gorest.co.in")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                retrofitService= retrofit.create(RetrofitService::class.java)

            }
          return retrofitService!!
        }


    }
}