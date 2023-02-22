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
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                ed.apply();
                startActivity(new Intent(Home_Activity.this,login_activity.class));
            }
        });

    }
}