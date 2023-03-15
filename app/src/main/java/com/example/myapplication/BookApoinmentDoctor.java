package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookApoinmentDoctor extends AppCompatActivity
{


    EditText name,mobile,adress;
    TextView titletext;
    Button confirm_appoinment,exit;
    DatabaseReference firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_apoinment_doctor);
        name=findViewById(R.id.name_book_apointment);
        mobile=findViewById(R.id.mobile_book_apoinment);
        adress=findViewById(R.id.adress_book_apoinment);
        confirm_appoinment=findViewById(R.id.conirm_appoinment_book_apoinment);
        exit=findViewById(R.id.exit_book_apoinment);
        titletext=findViewById(R.id.titletext_book_appoinment_details);
        firebaseDatabase=FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookApoinmentDoctor.this,Home_Activity.class));
            }
        });


        confirm_appoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                firebaseDatabase.child("BookApoinmentDetails").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        String Name=name.getText().toString();
                        String MobileNumber=mobile.getText().toString();
                        String Adress=adress.getText().toString();
                        firebaseDatabase.child("BookApoinmentDetails").child(Name).child("Name").setValue(Name);
                        firebaseDatabase.child("BookApoinmentDetails").child(Name).child("MobileNumber").setValue(MobileNumber);
                        firebaseDatabase.child("BookApoinmentDetails").child(Name).child("Adress").setValue(Adress);
                        titletext.setText("Ordered Confirmed");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });



    }

}