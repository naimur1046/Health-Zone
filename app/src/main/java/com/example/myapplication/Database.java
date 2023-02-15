package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
     private static String DATABASE_NAME="Health_Zone";
     private static String TABLE_NAME="User_Info";
     private static String PASSWORD="Password";
     private static String EMAIL="Email";
     private static String USER_NAME="User_Name";
     private static String MOVILE_NUMBER="Mobile_Number";
     private static int version=1;

     public Database(@Nullable Context context) {
        super(context, DATABASE_NAME , null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qury1="create table users(username text, email text , password text,mobilenumber text);";
        sqLiteDatabase.execSQL(qury1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  void register(String username,String email,String password,String mobilenumber)
    {
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);

        SQLiteDatabase db= getWritableDatabase();
        db.insert("users",null,cv);
        db.close();

    }
}
