package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    EditText edName,edPassword,edConfirmPassword,edEmail,edPhoneNumber;
    Button btn;
    TextView bottomText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                String username=edName.getText().toString();
                String password=edPassword.getText().toString();
                String ConfirmPassword=edConfirmPassword.getText().toString();
                String email=edEmail.getText().toString();
                String Phone_Number=edPhoneNumber.getText().toString();
                Database db= new  Database(getApplicationContext(),"Health_Zone",null,1);
                if(username.length()==0||password.length()==0||ConfirmPassword.length()==0||email.length()==0||Phone_Number.length()==0)
                {
                   bottomText.setText("Fill all the field");
                }
                else
                {
                    if(password.compareTo(ConfirmPassword)!=0)
                    {
                        bottomText.setText("Check the Password");
                    }
                    else
                    {
                        db.register(username.toString(),email.toString(),password.toString(),Phone_Number.toString());
                        bottomText.setText("Already Have an Acoount?");
                    }
                }

            }
        });
    }

}