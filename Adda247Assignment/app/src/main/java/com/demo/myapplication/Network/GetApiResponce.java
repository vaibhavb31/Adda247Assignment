package com.demo.myapplication.Network;

import com.demo.myapplication.Model.ApiResponce;



import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApiResponce {
    @GET("/public-api/users/")
   // Call<ApiResponce> getData();

    // using RX Java
    Observable<ApiResponce> getData();
}

