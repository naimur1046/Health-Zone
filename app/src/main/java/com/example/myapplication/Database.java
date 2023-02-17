package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
     private static String DATABASE_NAME="Health_Zone";
     private static String TABLE_NAME="User_Info";
     private static String PASSWORD="Password";
     private static String EMAIL="Email";
     private static String USER_NAME="User_Name";
     private static String MOVILE_NUMBER="Mobile_Number";
     private static int version=3;
     private static Context context;

     public Database(@Nullable Context context) {
        super(context, DATABASE_NAME , null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qury1=" CREATE TABLE " + TABLE_NAME +" ( " + USER_NAME+ " VARCHAR(20) , "+PASSWORD +" VARCHAR(20) , " +EMAIL+" VARCHAR(20) , " + MOVILE_NUMBER + " VARCHAR(20) " + " ); ";
        try {
            sqLiteDatabase.execSQL(qury1);
        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception is "+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        try
        {
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception is "+e, Toast.LENGTH_SHORT).show();
        }
    }
    public  void register(String username,String password,String email,String mobilenumber)
    {
        ContentValues cv = new ContentValues();
        cv.put(USER_NAME,username);
        cv.put(PASSWORD,password);
        cv.put(EMAIL,email);
        cv.put(MOVILE_NUMBER,mobilenumber);

        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);
        db.close();

    }
    public int login(String username,String password)
    {
        int result=0;
        SQLiteDatabase db= getReadableDatabase();
        String ara[]=new String[2];
        ara[0]=username;
        ara[1]=password;
        Cursor c=db.rawQuery(" SELECT * FROM "+TABLE_NAME+" WHERE "+USER_NAME+" =? "+" AND " +PASSWORD+" =? ",ara);
        if(c.moveToFirst())
        {
            result=1;
        }

        return result;
    }
}
