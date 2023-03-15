package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sp= getSharedPreferences("Simple_Data", Context.MODE_PRIVATE);
        String username=sp.getString("username","").toString();
        Toast.makeText(this, ""+username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.exit);
        CardView find_doctor = findViewById(R.id.find_doctor_home_activity);
        CardView blood_doner = findViewById(R.id.blood_doner_home_activity);
        CardView health_article=findViewById(R.id.Health_Article);
        CardView buy_medicine=findViewById(R.id.buy_medicine);
        CardView labtest = findViewById(R.id.labtest_home_activity);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                ed.apply();
                startActivity(new Intent(Home_Activity.this,login_activity.class));
            }
        });


        find_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this,Find_Doctor.class));
            }
        });

        blood_doner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, com.example.myapplication.blood_doner.class));
            }
        });
        health_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this,Health_Articles.class));
            }
        });

        buy_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home_Activity.this,Buy_Medicine.class));

            }
        });

        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this,Lab_Test.class));
            }
        });

    }
}