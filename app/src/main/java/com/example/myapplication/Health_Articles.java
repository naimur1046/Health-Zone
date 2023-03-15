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

public class Health_Articles extends AppCompatActivity {

    private String[][] health_details =
            {
                    {"Walking Daily","","","","Click for more details"},
                    {"Home care of COVID-19","","","","Click for more details"},
                    {"Stop Smoking","","","","Click for more details"},
                    {"Menstrual Cramps","","","","Click for more details"},
                    {"Healthy Gut","","","","Click for more details"}

            };

    private int[] image ={
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);
        lst=findViewById(R.id.listviewHA);
        btnBack=findViewById(R.id.buttonHABack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Health_Articles.this,Home_Activity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<health_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line 1", health_details[i][0]);
            item.put("line 2", health_details[i][1]);
            item.put("line 3", health_details[i][2]);
            item.put("line 4", health_details[i][3]);
            item.put("line 5", health_details[i][4]);
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
                Intent it=new Intent(Health_Articles.this,Health_Articles_Details.class);
                it.putExtra("text1",health_details[position][0]);
                it.putExtra("text2",image[position]);
                startActivity(it);
            }
        });
    }
}