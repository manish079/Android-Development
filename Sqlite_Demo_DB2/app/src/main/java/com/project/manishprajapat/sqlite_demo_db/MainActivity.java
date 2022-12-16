package com.project.manishprajapat.sqlite_demo_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.project.manishprajapat.sqlite_demo_db.data.MyDBHandler;
import com.project.manishprajapat.sqlite_demo_db.model.Contact;
import com.project.manishprajapat.sqlite_demo_db.params.Params;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDBHandler myDBHandler = new MyDBHandler(this);

        //Creating Contact object for DB
        Contact manish = new Contact();
        manish.setName("Manish");
        manish.setPhoneNumber("1010101010");
        myDBHandler.addContact(manish);   //adding first contact to the db

        Contact dhruv = new Contact();
        dhruv.setName("Dhruv");
        dhruv.setPhoneNumber("202020202020");
        myDBHandler.addContact(dhruv);   //adding second contact to the db

        Contact kamal = new Contact();
        kamal.setName("Kamal");
        kamal.setPhoneNumber("3030303030");
        myDBHandler.addContact(kamal);   //adding third contact to the db

        //Get All Contacts From Database
        List<Contact> allContacts = myDBHandler.getAllContact();
        for(Contact contact:allContacts){
            Log.d("dbManish", "Id: "+contact.getId() + "Name: "+contact.getName()+"\n"+
                    "phoneNumber: "+contact.getPhoneNumber());
        }

        /*Update data in database*/
        manish.setId(3);
        manish.setName("Manish Prajapat");
        manish.setPhoneNumber("6378861900");
        myDBHandler.updateContact(manish);
        Log.d("dbManish", "Successfully updated");

        /*delete all record of contact*/
        for(Contact contact:allContacts){
            myDBHandler.deleteContacts(contact.getId()+" ");
            Log.d("dbManish", "deleted"+ Params.KEY_ID+" \n");
        }
    }
}