package com.demo.myapplication.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.demo.myapplication.Model.ApiResponce;

import com.demo.myapplication.Repository.ApiRepo;



public class PostViewModel extends ViewModel {
    ApiRepo apiRepo;
    MutableLiveData<ApiResponce> getPost;
    public PostViewModel()
    {

        apiRepo= new ApiRepo();
    }
    public LiveData<ApiResponce> getPostData()
    {
        if(getPost==null)
        {
            getPost= apiRepo.getPostData();
        }
        return getPost;
    }

}
