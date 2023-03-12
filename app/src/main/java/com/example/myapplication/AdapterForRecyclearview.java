package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterForRecyclearview extends ArrayAdapter<DataFormateForRecyclerview>
{
    Activity contex;
    ArrayList<DataFormateForRecyclerview> items;
    public AdapterForRecyclearview(Activity context, ArrayList<DataFormateForRecyclerview> objects) {
        super(context,R.layout.sample_layout_for_recyclerview ,objects);
        context=contex;
        items=objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = contex.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout_for_recyclerview,null,true);
        DataFormateForRecyclerview dataStore=items.get(position);
        TextView name= view.findViewById(R.id.name_of_doctor_sample_layout);
        TextView age=view.findViewById(R.id.details_of_doctor_sample_layout);
        ImageView imageView=view.findViewById(R.id.image_smaple_layout);
        name.setText(dataStore.getName());
        age.setText(dataStore.getDetails());

        return view;
    }
}
