package com.sanmobi.machinetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Category {
    @SerializedName("categories")
    @Expose
    private ArrayList<ProductModel> modelList;

    public Category(ArrayList<ProductModel> modelList) {
        this.modelList = modelList;
    }

    public ArrayList<ProductModel> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<ProductModel> modelList) {
        this.modelList = modelList;
    }
}
