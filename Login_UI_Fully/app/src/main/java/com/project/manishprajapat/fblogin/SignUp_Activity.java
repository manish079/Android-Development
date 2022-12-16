package com.project.manishprajapat.fblogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.manishprajapat.fblogin.databinding.ActivitySignUpBinding;

public class SignUp_Activity extends AppCompatActivity {

    ActivitySignUpBinding signUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signUpBinding.getRoot());

        getSupportActionBar().setTitle("Sign Up");




        signUpBinding.registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = signUpBinding.name.getText().toString();
                String userEmail = signUpBinding.email.getText().toString();
                String userMobile = signUpBinding.mobile.getText().toString();
                String userPassword = signUpBinding.pass.getText().toString();


                if(userName.isEmpty()){
                    signUpBinding.name.setError("Enter name!!");
                }
                else if(userMobile.isEmpty()){
                    signUpBinding.mobile.setError("Enter Mobile!!");
                }
                else if(userEmail.isEmpty()){
                    signUpBinding.email.setError("Enter Email!!");
                }
                else if(userPassword.isEmpty()){
                    signUpBinding.pass.setError("Enter Password!!");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Successfully Registred", Toast.LENGTH_SHORT).show();
                }
            }
        });


        signUpBinding.tvAlreayAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpBinding.ivFb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        signUpBinding.ivGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
}