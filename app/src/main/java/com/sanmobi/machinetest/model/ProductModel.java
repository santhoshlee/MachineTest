package com.sanmobi.machinetest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductModel {

    @SerializedName("title")
    private String title;
    @SerializedName("products")
    private ArrayList<ProductChild> productChild;

    private boolean isexpend;


    public ProductModel(String title, ArrayList<ProductChild> productChild,boolean isexpend) {
        this.title = title;
        this.productChild = productChild;
    }

    public boolean isIsexpend() {
        return isexpend;
    }

    public void setIsexpend(boolean isexpend) {
        this.isexpend = isexpend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ProductChild> getProductChild() {
        return productChild;
    }

    public void setProductChild(ArrayList<ProductChild> productChild) {
        this.productChild = productChild;
    }
}
