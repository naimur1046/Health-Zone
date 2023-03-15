package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Doctor_Details extends AppCompatActivity
{
     TextView title;
     Button exit;


    private ArrayList<DataFormateForDoctorDetails> list;
    RecyclerView recyclerView;
    private AdapterRecyclerviewForDoctorDetails customAdapter;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        Intent intent = getIntent();
        String name_of_section= intent.getStringExtra("title");

        recyclerView=findViewById(R.id.recyclerview_doctor_details);
        title= findViewById(R.id.title_text);
        title.setText(""+name_of_section);
        exit = findViewById(R.id.doctor_details_exit_button);
        database= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        customAdapter= new AdapterRecyclerviewForDoctorDetails(this,list);
        recyclerView.setAdapter(customAdapter);


        database.child("Doctor_Details").child(name_of_section).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {

                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    String username=dataSnapshot.child("User Name").getValue(String.class);
                    String mobilenumber=dataSnapshot.child("PhoneNumber").getValue().toString();
                    mobilenumber=" 0"+mobilenumber;
                    String chember=dataSnapshot.child("Chember").getValue(String.class);
                    String schedule=dataSnapshot.child("Schedule").getValue(String.class);
                    DataFormateForDoctorDetails data= new DataFormateForDoctorDetails(username,chember,"",schedule,mobilenumber);
                    list.add(data);
                }
                customAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity( new Intent(Doctor_Details.this,Find_Doctor.class));
            }
        });




    }
}