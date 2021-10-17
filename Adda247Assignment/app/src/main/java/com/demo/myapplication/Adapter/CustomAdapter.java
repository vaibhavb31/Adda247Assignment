package com.demo.myapplication.Adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.demo.myapplication.Model.ApiResponce;
import com.demo.myapplication.Model.UserData;
import com.demo.myapplication.databinding.RowTileBinding;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    List<UserData> dataList;

    public CustomAdapter( List<UserData> dataList) {
        this.dataList = dataList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(RowTileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
        holder.rowtileBinding.nameData.setText(dataList.get(position).getName());
        holder.rowtileBinding.emailData.setText(dataList.get(position).getEmail());
        holder.rowtileBinding.genderData.setText(dataList.get(position).getGender());
        holder.rowtileBinding.statusData.setText(dataList.get(position).getStatus());

        if(holder.rowtileBinding.statusData.getText().toString().equals("active"))
        {
            holder.rowtileBinding.statusData.setTextColor(Color.parseColor("#66CC00"));


        }
        else
        {
            holder.rowtileBinding.statusData.setTextColor(Color.parseColor("#FF0000"));

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void refreshList(List<UserData> data) {
        this.dataList= data;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private RowTileBinding rowtileBinding;

        public CustomViewHolder(RowTileBinding rowtileBinding) {
            super(rowtileBinding.getRoot());
            this.rowtileBinding = rowtileBinding;
        }
    }
}
