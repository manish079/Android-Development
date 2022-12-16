package com.project.manishprajapat.firebase_excercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Already_Account_Activity extends AppCompatActivity {


    EditText mail,pass;
    Button loginBtn;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_account);

        mail = findViewById(R.id.loginEmail);
        pass = findViewById(R.id.loginPass);
        login = findViewById(R.id.tvCreateAcc);
        loginBtn = findViewById(R.id.login);

        getSupportActionBar().setTitle("Login");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String lmail = mail.getText().toString();
//                String lpassword = pass.getText().toString();


                //Checked If user already registred
             /*   DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Students");

//                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                //Note:- ValueEventListner gets fired only when that specific value changes, but ChildEventListner listens not only value of that node, but
                //also for all child nodes of tree.
                //addValueEventListener helps you to detect the changes in the data at particular path(including the children at that particular path).
                //This listener keeps listening till your app is connecgted to the firebase.
                //addChildEventListener-> when workling with the lists of data, we should use this listener. This listener helps you listen to the evenet relted
                //to the partiiular of a child node of root.  */


//                Query query = databaseReference.orderByChild("userName").equalTo(lpassword);

//                query.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                        if(snapshot.exists()){
//
//                            String passwordFromDB =  snapshot.child(lmail).child("password").getValue(String.class);
//
//                            if(passwordFromDB.equals(lpassword)){
//
//                                Toast.makeText(getApplicationContext(), "ALready exits this mail", Toast.LENGTH_SHORT).show();
//
//                            }
//                            else
//                                pass.setError("Wrong password!!");
//                        }
//                        else
//                            mail.setError("No such user exist");
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
            }
        });




    }
}