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

public class Buy_Medicine_Details extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost,titletext;
    EditText username,mobilename,adress;
    Button btnConfirmOder,btnBack;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://health-zone-379113-default-rtdb.firebaseio.com/");

        username=findViewById(R.id.name_book_apointment);
        mobilename=findViewById(R.id.mobile_book_apoinment);
        adress=findViewById(R.id.adress_book_apoinment);


        tvPackageName=findViewById(R.id.titletext_book_appoinment_details);
        tvTotalCost=findViewById(R.id.textViewBMDTotalCost);
        btnBack=findViewById(R.id.exit_book_apoinment);
        titletext=findViewById(R.id.textViewBMDTitleText);
        btnConfirmOder=findViewById(R.id.conirm_appoinment_book_apoinment);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text2")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Buy_Medicine_Details.this,Buy_Medicine.class));
                titletext.setText("To confirm order, please provide the following information");


            }
        });
        btnConfirmOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               titletext.setText("ORDER CONFIRMED");
                databaseReference.child("MedicineOrderDetails").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        String UserName=username.getText().toString();
                        String MobileNumber=mobilename.getText().toString();
                        String Adress=adress.getText().toString();
                        databaseReference.child("MedicineOrderDetails").child(UserName).child("UserName").setValue(UserName);
                        databaseReference.child("MedicineOrderDetails").child(UserName).child("MobileNumber").setValue(MobileNumber);
                        databaseReference.child("MedicineOrderDetails").child(UserName).child("Adress").setValue(Adress);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }
}