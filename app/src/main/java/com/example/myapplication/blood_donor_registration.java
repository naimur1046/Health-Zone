package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
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

public class blood_donor_registration extends AppCompatActivity
{
    private EditText UserName,Password,ConfirmPassword,MoblileNumber,BloodGroup,LastDonation;
    Button Register;
    TextView AlreadyHaveAccount;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donor_registration);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");
        UserName=findViewById(R.id.username_blood_doner_registration);
        Password=findViewById(R.id.password_blood_doner_registration);
        ConfirmPassword=findViewById(R.id.confirm_password_blood_doner_registration);
        MoblileNumber=findViewById(R.id.mobile_bood_donar_registration);
        BloodGroup=findViewById(R.id.blood_group_blood_doner_registration);
        LastDonation=findViewById(R.id.last_donation_blood_donar_registration);
        Register=findViewById(R.id.register_blood_doner_registration);
        AlreadyHaveAccount=findViewById(R.id.already_have_an_account);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                databaseReference.child("Blood_Donors").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        String username=UserName.getText().toString();
                        String password=Password.getText().toString();
                        String confirmpassword=ConfirmPassword.getText().toString();
                        String mobilenumber=MoblileNumber.getText().toString();
                        String bloodgroup=BloodGroup.getText().toString();
                        String lastdonation=LastDonation.getText().toString();
                        if(snapshot.hasChild(username))
                        {
                            Toast.makeText(blood_donor_registration.this, "Change Your UserName", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                            databaseReference.child("Blood_Donors").child(username).child("UserName").setValue(username);
                            databaseReference.child("Blood_Donors").child(username).child("Password").setValue(password);
                            databaseReference.child("Blood_Donors").child(username).child("ConfirmPassword").setValue(confirmpassword);
                            databaseReference.child("Blood_Donors").child(username).child("MobileNumber").setValue(mobilenumber);
                            databaseReference.child("Blood_Donors").child(username).child("BloodGroup").setValue(bloodgroup);
                            databaseReference.child("Blood_Donors").child(username).child("LastDonation").setValue(lastdonation);

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