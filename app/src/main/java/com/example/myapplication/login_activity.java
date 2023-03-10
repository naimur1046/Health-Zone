



package com.example.myapplication;


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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login_activity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText edUsername,edPassword;
    Button login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

                    databaseReference= FirebaseDatabase.getInstance().getReference("Normal_User");


                    if (1==0)
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
                        Toast.makeText(login_activity.this, "Not ok ", Toast.LENGTH_SHORT).show();
                    }
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