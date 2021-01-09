package com.sanmobi.machinetest.network;

import com.sanmobi.machinetest.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

   @GET("5ec39cba300000720039c1f6")
   Call<Category> getProductList();
}
