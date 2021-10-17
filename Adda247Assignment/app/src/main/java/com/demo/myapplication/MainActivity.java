package com.demo.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.demo.myapplication.Adapter.CustomAdapter;
import com.demo.myapplication.Model.ApiResponce;
import com.demo.myapplication.Model.UserData;
import com.demo.myapplication.ViewModel.PostViewModel;
import com.demo.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    ActivityMainBinding activityMainBinding;
    PostViewModel postViewModel;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        recyclerView = activityMainBinding.recycle;

        initUi();
        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPostData().observe(this, new Observer<ApiResponce>() {
            @Override
            public void onChanged(ApiResponce apiResponce) {
                Log.d("test", apiResponce.toString());
                getAllData(apiResponce.getData());


            }


        });



    }

    private void getAllData(List<UserData> data) {
        customAdapter.refreshList(data);
    }

    private void initUi() {
        customAdapter = new CustomAdapter(new ArrayList<UserData>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);
    }
}