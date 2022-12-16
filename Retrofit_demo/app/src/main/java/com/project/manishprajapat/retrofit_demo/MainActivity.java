package com.project.manishprajapat.retrofit_demo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    TextView tvPosts;
    ListView listView;


    API_Interface api_interface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPosts = findViewById(R.id.tv_posts);
        listView=findViewById(R.id.list_view);

        api_interface = Retrofit_Instance.getRetrofit().create(API_Interface.class);


        api_interface.getData().enqueue(new Callback<List<POJO>>() {
            @Override
            public void onResponse(Call<List<POJO>> call, Response<List<POJO>> response) {

                if(response.body().size() > 0){
                    List<POJO> pojoList = response.body();
                   ArrayAdapter<POJO> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,pojoList);
                    listView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(MainActivity.this, "Posts are not available", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<POJO>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}