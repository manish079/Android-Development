package com.project.manishprajapat.retrofit_demo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API_Interface {

    @GET("posts")
    Call<List<POJO>> getData();  //call used for http request

}
