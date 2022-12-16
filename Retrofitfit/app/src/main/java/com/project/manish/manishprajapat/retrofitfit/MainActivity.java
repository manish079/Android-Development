package com.project.covid.manishprajapat.retrofitfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    TextView textView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.sv);
        textView=findViewById(R.id.textView);

        RetrofitService retrofitService=new RetrofitService();

        ApiInterface apiInterface = retrofitService.retrofit.create(ApiInterface.class);   //ya pe ApiInterface.class ki implementation khud retrofit kr rhi he

         Call<List<ModelClass>> modelClass = apiInterface.getPosts();
        modelClass.enqueue(new Callback<List<ModelClass>>() {    //Enqueue basically background thread me work karenga
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {

                if (response.isSuccessful()) {
                    for (ModelClass modelClass1 : response.body()) {
                        showPosts(modelClass1);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showPosts(ModelClass modelClass1) {
        textView.append("UserId: " + modelClass1.getUserId());
        textView.append("Id: " + modelClass1.getId());
        textView.append("title: " + modelClass1.getTitle());
        textView.append("body: " + modelClass1.getBody());
    }
}