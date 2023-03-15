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

public class Lab_Test_Details extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost,titletext_labtest;
    EditText name,mobile,adress;
    Button btnConfirmOder,btnBack;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName=findViewById(R.id.titletext_book_appoinment_details);
        tvTotalCost=findViewById(R.id.textViewBMDTotalCost);
        btnBack=findViewById(R.id.exit_book_apoinment);
        btnConfirmOder=findViewById(R.id.buttonLTDConfirmOrder);
        titletext_labtest=findViewById(R.id.titletext_lab_test);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");
        name=findViewById(R.id.name_labtest_details);
        mobile=findViewById(R.id.mobile_lab_test);
        adress=findViewById(R.id.adress_labtest_details);


        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text2")+"/-");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lab_Test_Details.this,Lab_Test.class));
            }
        });
        btnConfirmOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titletext_labtest.setText("Order Confirmed");

                databaseReference.child("LabTest").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {

                        String Name=name.getText().toString();
                        String MobileNumber=mobile.getText().toString();
                        String Adress=adress.getText().toString();
                        databaseReference.child("LabTest").child(Name).child("UserName").setValue(Name);
                        databaseReference.child("LabTest").child(Name).child("MobileNumber").setValue(MobileNumber);
                        databaseReference.child("LabTest").child(Name).child("Adress").setValue(Adress);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });

    }
}