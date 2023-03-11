package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class Register_Activity extends AppCompatActivity {
    EditText edName,edPassword,edConfirmPassword,edEmail,edPhoneNumber;
    Button btn;
    TextView bottomText;


    DatabaseReference databaseReference;
    DatabaseReference databaseReferenceforuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseReferenceforuser=FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");
        edName=findViewById(R.id.userName);
        edPassword=findViewById(R.id.password);
        edConfirmPassword=findViewById(R.id.confirm_password);
        edEmail=findViewById(R.id.email);
        edPhoneNumber=findViewById(R.id.phone_number);
        btn=findViewById(R.id.register_button);
        bottomText=findViewById(R.id.bottom_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username=edName.getText().toString().trim();
                String password=edPassword.getText().toString().trim();
                String ConfirmPassword=edConfirmPassword.getText().toString().trim();
                String email=edEmail.getText().toString().trim();
                String Phone_Number=edPhoneNumber.getText().toString().trim();


                if(username.length()==0||password.length()==0||ConfirmPassword.length()==0||email.length()==0||Phone_Number.length()==0)
                {
                   bottomText.setText("Fill all the field");
                }
                else
                {
                    databaseReference= FirebaseDatabase.getInstance().getReference("Normal_User");
                    String key = databaseReference.push().getKey();
                    FirebaseUpload dataStore=new FirebaseUpload(username,password,email,Phone_Number);
                    databaseReference.child(key).setValue(dataStore);



                    databaseReferenceforuser.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot)
                        {

                            if(snapshot.hasChild(username))
                            {
                                Toast.makeText(Register_Activity.this, "User Already Registered", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {

                                databaseReferenceforuser.child("users").child(username).setValue(password);
                                finish();
                            }

                            }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    Intent intent = new Intent(Register_Activity.this,Home_Activity.class);
                    startActivity(intent);

                }

            }
        });
    }

}