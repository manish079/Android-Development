package com.example.sql_lite_demo;

public class Modalclass {
    public static  String dbname = "Mydb";
    public static  String tablename = "Mytable ";
    public static  int dbversion = 1;
    public static final String ID= "Id";
    public static final String Note= "Note";
    public static final String Time_Stamp= "TimeStamp";

    int id;
    String note, timestamp;

    public static  String Create_table = "create table "+tablename+" ( "
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Note + " TEXT,"
            +Time_Stamp + " DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";

    public Modalclass() {
    }

    public static String getDbname() {
        return dbname;
    }

    public static void setDbname(String dbname) {
        Modalclass.dbname = dbname;
    }

    public static String getTablename() {
        return tablename;
    }

    public static void setTablename(String tablename) {
        Modalclass.tablename = tablename;
    }

    public static int getDbversion() {
        return dbversion;
    }

    public static void setDbversion(int dbversion) {
        Modalclass.dbversion = dbversion;
    }

    public static String getCreate_table() {
        return Create_table;
    }

    public static void setCreate_table(String create_table) {
        Create_table = create_table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
