package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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
        cv.put("username",username.toString());
        cv.put("email",email.toString());
        //cv.put("password",password.toString());
        //cv.put("mobilenumber",mobilenumber.toString());
        SQLiteDatabase db= getWritableDatabase();
        db.insert("users",null,cv);
        db.close();

    }
}
