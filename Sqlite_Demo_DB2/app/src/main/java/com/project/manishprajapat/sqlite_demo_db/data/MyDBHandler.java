package com.project.manishprajapat.sqlite_demo_db.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.project.manishprajapat.sqlite_demo_db.model.Contact;
import com.project.manishprajapat.sqlite_demo_db.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    public MyDBHandler(Context context) {
        super(context, Params.DB_NAME,null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "create table "+Params.TABLE_NAME+ "("
                +Params.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Params.KEY_NAME+" TEXT,"
                +Params.KEY_PHONE+" TEXT"
                + ")";


        /*This is also method to create database*/
//        String create ="create table contact_table "+
//                "(id integer primary key autoincrement,"+
//                "name text,"+
//                "phoneNumber text)";


        db.execSQL(create);
        Log.d("dbManish", "Create Successfully table: "+create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Params.TABLE_NAME);
        //Create table again
        onCreate(db);
    }

    //Add contact to database
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());
        Log.d("dbManish","contact Successfully added in Database: "+ contact.getName());
        db.close();
    }

//     Read contacts
    public List<Contact> getAllContact(){

        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

//        String select_query = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery("select * From "+Params.TABLE_NAME,null);

        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return contactList;
    }

    //Delete Contact from database
    public void deleteContacts(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();

    }

    //Update contact from database
    public void updateContact(Contact contact){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());
        database.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{String.valueOf(contact.getId())});
        database.close();
    }
}
