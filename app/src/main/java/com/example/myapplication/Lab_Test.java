package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab_Test extends AppCompatActivity {
    private String[][] packages={
            {"Package 1 : Full Body Checkup","","","","10000"},
            {"Package 2 : Blood Glucose Fasting","","","","500"},
            {"Package 3 : Covid-19 Antibody","","","","600"},
            {"Package 4 : Thyroid Check","","","","700"},
            {"Package 5 : Immunity Check","","","","1500"}
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,confirm_order;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        lst=findViewById(R.id.listviewLT);
        btnBack=findViewById(R.id.buttonLTBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lab_Test.this,Home_Activity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line 1", packages[i][0]);
            item.put("line 2", packages[i][1]);
            item.put("line 3", packages[i][2]);
            item.put("line 4", packages[i][3]);
            item.put("line 5","Total Cost : "+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it=new Intent(Lab_Test.this,Lab_Test_Details.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",packages[position][4]);
                startActivity(it);
            }
        });
    }
}