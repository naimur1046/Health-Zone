package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class Find_Doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // This section is for family physician entry

        CardView family_physician = findViewById(R.id.family_physician);
        family_physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                    intent.putExtra("title","FAMILY PHYSICIAN");
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }
        });

        // this part is for dietician entry

       CardView dietician = findViewById(R.id.ditetian);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                    intent.putExtra("title","D I E T I C I A N");
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }
        });

        // this part is for Dentist entry

        CardView dentist = findViewById(R.id.dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try
               {
                   Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                   intent.putExtra("title","D E N T I S T");
                   startActivity(intent);
               }
               catch (Exception e)
               {

               }
            }
        });

        // This part is for surgeon

        CardView surgeon = findViewById(R.id.surgian);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                    intent.putExtra("title"," S U R G E O N ");
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }
        });


        // This part is for Heart specialist

        CardView Heart_Specialist = findViewById(R.id.heart_specialist);
        Heart_Specialist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try
               {
                   Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                   intent.putExtra("title","H E A R T  S P E C I L I S T");
                   startActivity(intent);
               }
               catch (Exception e)
               {

               }
            }
        });

        // This part is for venereologist

        CardView venereologist = findViewById(R.id.venereologist);
        venereologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Find_Doctor.this,Doctor_Details.class);
                    intent.putExtra("title","V E N E R E O L O G I S T");
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }
        });

    }
}