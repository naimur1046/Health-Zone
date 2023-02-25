package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class New_User extends AppCompatActivity
{
    TableRow blood;
    TableRow doctor;
    TableRow normal_user;
    TableRow medicalshop_owner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        normal_user = findViewById(R.id.normal_user);
        normal_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(New_User.this,Register_Activity.class));
            }
        });
    }
}