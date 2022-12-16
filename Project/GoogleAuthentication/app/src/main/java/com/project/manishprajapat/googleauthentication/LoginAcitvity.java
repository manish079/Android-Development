package com.project.manishprajapat.googleauthentication;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginAcitvity extends AppCompatActivity implements View.OnClickListener {

    public FirebaseAuth auth;
    EditText email, pass;
    Button login_btn;
    TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);

        auth = FirebaseAuth.getInstance();

        pass = findViewById(R.id.etPass);
        email = findViewById(R.id.etMail);
        login_btn = findViewById(R.id.login_btn);
        signup = findViewById(R.id.tvSignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String user_pass = pass.getText().toString().trim();
        String user_email = email.getText().toString().trim();

        if (TextUtils.isEmpty(user_pass)) {
            pass.setError("Please enter name");
        }
         else if (TextUtils.isEmpty(user_email)) {
            email.setError("Please enter e-mail");
        }

               else {

                   auth.signInWithEmailAndPassword(user_email,user_pass)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if(task.isSuccessful()){
                                       Toast.makeText(getApplicationContext(), "User found: Loging Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainContentActivity.class);
                                        startActivity(intent);
                                   }

                                   else{
                                       Toast.makeText(getApplicationContext(), " "+task.getException(), Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });

        }
    }

}