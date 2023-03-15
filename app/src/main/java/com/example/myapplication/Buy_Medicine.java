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

public class Buy_Medicine extends AppCompatActivity {

    private String[][] packages= {
            {"Uprise03 Capsule", "", "", "", "50"},
            {"HealthVit Capsule", "", "", "", "500"},
            {"Vitamin3 Capsule", "", "", "", "200"},
            {"Tata Calcium", "", "", "", "250"},
            {"Feronia tablet", "", "", "", "350"},
            {"Dolo 650 Tablet", "", "", "", "150"},
            {"Inlife Vitamin E Capsule", "", "", "", "180"},
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst=findViewById(R.id.listviewBM);
        btnBack=findViewById(R.id.exit_book_apoinment);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Buy_Medicine.this,Home_Activity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line 1", packages[i][0]);
            item.put("line 2", packages[i][1]);
            item.put("line 3", packages[i][2]);
            item.put("line 4", packages[i][3]);
            item.put("line 5", packages[i][4]);
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
                Intent it=new Intent(Buy_Medicine.this,Buy_Medicine_Details.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",packages[position][4]);
                startActivity(it);
            }
        });

    }
}