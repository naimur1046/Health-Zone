package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doctor_register extends AppCompatActivity
{


   private Button register;
   private EditText mobilenumber,username,password,doctor_category,chember,schedule;

   DatabaseReference databaseReference;

   private static final int IMAGE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        register=findViewById(R.id.register_blood_doner_registration);
        username=findViewById(R.id.username_blood_doner_registration);
        password=findViewById(R.id.blood_group_blood_doner_registration);
        doctor_category=findViewById(R.id.blood_group);
        mobilenumber=findViewById(R.id.phone_number_doctor_registration);
        chember=findViewById(R.id.doctor_chember_doctor_register);
        schedule=findViewById(R.id.doctor_schedule_doctor_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                databaseReference.child("Doctor_Details").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {

                        if(snapshot.hasChild(username.getText().toString()))
                        {
                            Toast.makeText(doctor_register.this, "Change Your UserName", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            databaseReference.child("Doctor_Details").child(doctor_category.getText().toString()).child(username.getText().toString()).child("User Name").setValue(username.getText().toString());
                            databaseReference.child("Doctor_Details").child(doctor_category.getText().toString()).child(username.getText().toString()).child("Password").setValue(password.getText().toString());
                            databaseReference.child("Doctor_Details").child(doctor_category.getText().toString()).child(username.getText().toString()).child("PhoneNumber").setValue(mobilenumber.getText().toString());
                            databaseReference.child("Doctor_Details").child(doctor_category.getText().toString()).child(username.getText().toString()).child("Chember").setValue(chember.getText().toString());
                            databaseReference.child("Doctor_Details").child(doctor_category.getText().toString()).child(username.getText().toString()).child("Schedule").setValue(schedule.getText().toString());

                            finish();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }

}