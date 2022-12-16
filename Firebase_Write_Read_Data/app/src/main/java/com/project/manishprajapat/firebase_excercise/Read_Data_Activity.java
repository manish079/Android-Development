package com.project.manishprajapat.firebase_excercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Read_Data_Activity extends AppCompatActivity {


    Button btn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        getSupportActionBar().setTitle("Reading Data");

        btn=findViewById(R.id.show);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Students").child("manish");;  //I want to get only manish information from daatbse so write .child("mansih)
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

//                        String data = snapshot.getValue(String.class);   // Error->>> Failed to convert value of type java.util.HashMap to String

                          //below line is correct for getting data here we get the data of manish    // databaseReference = firebaseDatabase.getReference("Students").child("manish");
                        //String data = snapshot.getValue().toString();   //If we not user child in database refernce aboce then we also write here--> snapshot.child("manish").getValue().toString();

                        //If I want to print individual child data one by one here getChildern() iiterator
                        for(DataSnapshot snapshot1:snapshot.getChildren()){
                            String str=snapshot.toString();       // String str=snapshot.child("Students").toString(); we also use. but for this we will write above only  databaseReference = firebaseDatabase.getReference("Students");
                            Toast.makeText(getApplicationContext(), " "+str, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}