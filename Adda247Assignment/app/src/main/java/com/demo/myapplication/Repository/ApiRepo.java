package com.demo.myapplication.Repository;

import androidx.lifecycle.MutableLiveData;

import com.demo.myapplication.Model.ApiResponce;
import com.demo.myapplication.Model.UserData;
import com.demo.myapplication.Network.GetApiResponce;
import com.demo.myapplication.Network.RetroClient;

import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class ApiRepo {

    public MutableLiveData<ApiResponce> getPostData() {
        final MutableLiveData<ApiResponce> postModel = new MutableLiveData<>();
        GetApiResponce getApiResponce = RetroClient.getInstance().create(GetApiResponce.class);

        // using RX java
        getApiResponce.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ApiResponce>() {
                    @Override
                    public void onNext( ApiResponce apiResponce) {
                       postModel.setValue(apiResponce);
                    }

                    @Override
                    public void onError( Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        return postModel;
    }
}
