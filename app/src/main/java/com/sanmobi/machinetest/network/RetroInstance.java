package com.sanmobi.machinetest.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BASE_URL="https://www.mocky.io/v2/";

    public static Retrofit retrofit;

    public  static  Retrofit getRetrofitClient() {

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
        }
        return retrofit;
    }
}
