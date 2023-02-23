package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Doctor_Details extends AppCompatActivity
{
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        Intent intent = getIntent();
        String name_of_section= intent.getStringExtra("title");

        textView= findViewById(R.id.title_text);
        textView.setText(""+name_of_section);

    }
}