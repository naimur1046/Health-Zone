package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class blood_doner extends AppCompatActivity {
    private ArrayList<DataFormateForRecyclerview> list;
    RecyclerView recyclerView;
    private AdapterRecyclerviewForBloodDoner customAdapter;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_doner);

        recyclerView=findViewById(R.id.recyclerview_doctor_details);
        database=FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        customAdapter= new AdapterRecyclerviewForBloodDoner(this,list);
        recyclerView.setAdapter(customAdapter);
        database.child("Blood_Donors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    String username=dataSnapshot.child("UserName").getValue(String.class);
                    String mobilenumber=dataSnapshot.child("MobileNumber").getValue().toString();
                    String bloodgroup=dataSnapshot.child("BloodGroup").getValue(String.class);
                    String lastdonatetime=dataSnapshot.child("LastDonation").getValue(String.class);
                    DataFormateForRecyclerview data= new DataFormateForRecyclerview(bloodgroup,username,mobilenumber,lastdonatetime);
                    list.add(data);
                }
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}