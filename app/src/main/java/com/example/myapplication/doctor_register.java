package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URI;

public class doctor_register extends AppCompatActivity
{


   private Button register;
   private TextView choice_photo,username,password,doctor_category;
   private ImageView doctor_photo;

   DatabaseReference databaseReference;

   private static final int IMAGE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        register=findViewById(R.id.register_button);
        doctor_photo=findViewById(R.id.doctor_image);
        username=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        choice_photo=findViewById(R.id.choice_photo);
        doctor_category=findViewById(R.id.doctor_category);

        choice_photo.setOnClickListener(new View.OnClickListener() {
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

                            databaseReference.child("Doctor_Details").child(username.getText().toString()).setValue(password.getText().toString());
                            databaseReference.child("Doctor_Details").child(username.getText().toString()).setValue(doctor_category.getText().toString());
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