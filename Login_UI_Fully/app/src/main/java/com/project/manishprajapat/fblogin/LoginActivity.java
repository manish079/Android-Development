package com.project.manishprajapat.fblogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.project.manishprajapat.fblogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bindingLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       bindingLogin = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLogin.getRoot());

        getSupportActionBar().setTitle("Login");

        bindingLogin.tvDontAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        bindingLogin.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userloginEmail =bindingLogin.email.getText().toString();
                String userLoginPassword = bindingLogin.pass.getText().toString();

                if(userloginEmail.isEmpty())
                    bindingLogin.email.setError("Enter E-Mail");
                else if(userLoginPassword.isEmpty())
                     bindingLogin.pass.setError("Enter Password");
                else
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();

            }
        });


        //Login Using facebook

        bindingLogin.ivFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Login Using Google
        bindingLogin.ivGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });








    }
}