package com.demo.kotlinassignmentadda247.Repository

import com.demo.kotlinassignmentadda247.Network.RetrofitService

class ApiRepo constructor(private val retrofitService: RetrofitService) {
    fun getUserData()= retrofitService.getData()
}