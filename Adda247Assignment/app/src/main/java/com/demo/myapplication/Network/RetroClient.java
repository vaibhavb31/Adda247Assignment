package com.demo.myapplication.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    public static Retrofit retrofit;


    public static Retrofit getInstance()
    {
        if(retrofit==null)
        {

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://gorest.co.in")
                    
                    // FOR rx java
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }
}
