package com.demo.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponce {

    @SerializedName("data")
    private List<UserData> data;

    public ApiResponce(List<UserData> data) {
        this.data = data;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }
}
