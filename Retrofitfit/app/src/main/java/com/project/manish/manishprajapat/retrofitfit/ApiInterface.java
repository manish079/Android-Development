package com.project.covid.manishprajapat.retrofitfit;

import android.graphics.ColorSpace;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiInterface {

     String BASE_URL="https://jsonplaceholder.typicode.com/";
     public String FEED="posts";

    @GET("FEED")
    Call<List<ModelClass>> getPosts();
}
