package com.example.sql_lite_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Mydp_helper extends SQLiteOpenHelper {

    public Mydp_helper(@Nullable Context context) {
        super(context, Modalclass.getDbname(), null, Modalclass.getDbversion());
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Modalclass.Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Modalclass.getTablename());
        onCreate(db);
    }

    public void insert(String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Modalclass.Note, note);
        db.insert(Modalclass.getTablename(), null, values);
        db.close();
    }

    public  List<Modalclass> getallnodes() {
        List<Modalclass> list = new ArrayList<>();
        String query = "SELECT * FROM " + Modalclass.tablename + "ORDER BY " +
                Modalclass.Time_Stamp + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                Modalclass modalclass = new Modalclass();
                modalclass.setId(cursor.getInt(0));
                modalclass.setNote(cursor.getString(1));
                modalclass.setTimestamp(cursor.getString(2));
                list.add(modalclass);
            }while (cursor.moveToNext());
        }
        return list;

    }
    public int getcount()
    {
        int count=0;
        String query = "select * from "+Modalclass.tablename;
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery(query,null);

        count = cursor.getCount();
        return count;
    }
    public void updateNote(String note, int position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Modalclass.Note, note);

        // updating row
        db.update(Modalclass.tablename, values, Modalclass.ID+ " = ?",
                new String[]{String.valueOf(position)});
    }

}
