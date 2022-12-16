package com.project.manishprajapat.firebase_excercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
        EditText name,pass,mobile,email;
        Button btn;
        TextView alreadyAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Create Database");

        name = findViewById(R.id.etName);
        pass = findViewById(R.id.ePass);
        email = findViewById(R.id.etEmail);
        mobile = findViewById(R.id.etMobile);
        btn = findViewById(R.id.button);
        alreadyAccount = findViewById(R.id.tvAlready);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = name.getText().toString();
                String userMobile = mobile.getText().toString();
                String userEmail = email.getText().toString();
                String userPass = pass.getText().toString();

                if(TextUtils.isEmpty(userName)){
                    name.setError("Name Required!");
                }
                else if(TextUtils.isEmpty(userMobile)){
                    mobile.setError("Mobile Required");
                }
                else if(TextUtils.isEmpty(userEmail)){
                    email.setError("Email Required!");
                }
                else if(TextUtils.isEmpty(userPass)){
                    pass.setError("Password Required!");
                }

                else
                    writeStudentData(userName,userMobile,userEmail,userPass);
            }
        });

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Already_Account_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void writeStudentData(String userName, String userMobile, String userEmail, String userPass){
        StudentModel model = new StudentModel(userName, userMobile, userEmail, userPass);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Students");
        database.child(userName).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                name.setText("");
                email.setText("");
                pass.setText("");
                mobile.setText("");
                Toast.makeText(MainActivity.this,"added",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),Read_Data_Activity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"failed!!",Toast.LENGTH_LONG).show();

            }
        });

    }
}