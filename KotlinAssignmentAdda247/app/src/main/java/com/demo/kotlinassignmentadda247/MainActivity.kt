package com.demo.kotlinassignmentadda247

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.kotlinassignmentadda247.Adapter.CustomAdapter
import com.demo.kotlinassignmentadda247.Network.RetrofitService
import com.demo.kotlinassignmentadda247.Repository.ApiRepo
import com.demo.kotlinassignmentadda247.ViewModel.PostViewModel
import com.demo.kotlinassignmentadda247.ViewModel.PostViewModelFactory
import com.demo.kotlinassignmentadda247.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: PostViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = CustomAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      val layoutManager:  RecyclerView.LayoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this, PostViewModelFactory(ApiRepo(retrofitService)))
            .get(PostViewModel::class.java)
        binding.recycle.layoutManager= layoutManager

        binding.recycle.adapter = adapter

        viewModel.userList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.refreshList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
        })

        viewModel.getData()
    }
}