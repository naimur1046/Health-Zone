



package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import okhttp3.internal.cache.DiskLruCache;

public class login_activity extends AppCompatActivity {

    DatabaseReference databaseReferenceforlogin;
    EditText edUsername,edPassword;
    Button login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        databaseReferenceforlogin=FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");
        edUsername=findViewById(R.id.userName);
        edPassword=findViewById(R.id.confirm_password);
        login=findViewById(R.id.button1);
        register=findViewById(R.id.bolttom);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                if(name.length()==0||password.length()==0)
                {
                    register.setText("Please enter login info");
                }
                else
                {

                    databaseReferenceforlogin.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(name))
                            {
                                String Get_Password=snapshot.child(name).getValue(String.class);
                                if(Get_Password.equals(password))
                                {
                                    Toast.makeText(login_activity.this, "Information is ok", Toast.LENGTH_SHORT).show();
                                    SharedPreferences sp= getSharedPreferences("Simple_Data", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("User_Name",name);
                                    editor.putString("Password",password);
                                    editor.apply();
                                    startActivity( new Intent(login_activity.this,Home_Activity.class));
                                }
                                else
                                {
                                    Toast.makeText(login_activity.this, "Your Information is not OK", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_activity.this,New_User.class));
            }
        });
    }
}