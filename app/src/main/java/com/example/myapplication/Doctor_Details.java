package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Doctor_Details extends AppCompatActivity
{
     TextView title;
     Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        Intent intent = getIntent();
        String name_of_section= intent.getStringExtra("title");

        title= findViewById(R.id.title_text);
        title.setText(""+name_of_section);
        exit = findViewById(R.id.doctor_details_exit_button);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity( new Intent(Doctor_Details.this,Find_Doctor.class));
            }
        });
    }
}