package com.sanmobi.machinetest.model;

import com.google.gson.annotations.SerializedName;

public class ProductChild {

    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private String price;
    @SerializedName("imageUrl")
    private String proUrl;
    @SerializedName("description")
    private String description;

    public ProductChild(String title, String price, String proUrl, String description) {
        this.title = title;
        this.price = price;
        this.proUrl = proUrl;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
