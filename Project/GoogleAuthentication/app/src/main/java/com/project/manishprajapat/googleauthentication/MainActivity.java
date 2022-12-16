package com.project.manishprajapat.googleauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.project.manishprajapat.googleauthentication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public FirebaseAuth auth;
    EditText mail, user,pass,con_pass;
    Button register;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        mail=findViewById(R.id.etMail);
        user=findViewById(R.id.etName);
        pass=findViewById(R.id.etPassword);
        con_pass=findViewById(R.id.etConfermpassword);
        register=findViewById(R.id.register_btn);
        login = findViewById(R.id.login);

        register.setOnClickListener(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginAcitvity.class);
                startActivity(intent);
                finish();
            }
        });

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = auth.getCurrentUser();
//        alreadyUser(currentUser);
//
//    }
//
//    public void alreadyUser(FirebaseUser CurrentUser){
//        Toast.makeText(this, "Already user log In", Toast.LENGTH_SHORT).show();
//
//    }
//
    @Override
    public void onClick(View v) {

            String user_name = user.getText().toString().trim();
            String email = mail.getText().toString().trim();
            String password = pass.getText().toString().trim();
            String conform_pass = con_pass.getText().toString().trim();

            if (TextUtils.isEmpty(user_name)) {
                user.setError("Please enter name");
            }
            else if (TextUtils.isEmpty(email)) {
                mail.setError("Please enter e-mail");

            }

            else if (TextUtils.isEmpty(password)) {
                pass.setError("Please enter password");

            }

            else if (TextUtils.isEmpty(user_name)) {
                con_pass.setError("Please confirm your password");

            }
            else if(!password.equals(conform_pass)){
                Toast.makeText(this, "Please enter valid password", Toast.LENGTH_SHORT).show();
            }
            else {

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "User logging Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginAcitvity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(getApplicationContext(), "Something went wrong!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
//                auth.createUserWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    Log.d("USER", "createUserWithEmail:success");
//                                    FirebaseUser user = auth.getCurrentUser();
//                                    updateUI(user);//                                } else {
//                                    Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
//                                }
//                            }
//                        });
            }
        }
//    private void updateUI(FirebaseUser user) {
//        Intent intent = new Intent(this,MainContentActivity.class);
//        startActivity(intent);
    }
