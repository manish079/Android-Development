package com.project.manishprajapat.retrofit_demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Instance {

    public static Retrofit retrofit=null;
    public  static final String BASE_URL= "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit() {

        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                      addConverterFactory(GsonConverterFactory.   //Convert json into java object using GsonConvertFacory
                              create()).
                   build();

        }
        return retrofit;
    }

}
