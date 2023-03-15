package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerviewForBloodDoner extends RecyclerView.Adapter<AdapterRecyclerviewForBloodDoner.MyViewHolder>
{

    Context context;
    ArrayList<DataFormateForRecyclerview> items;

    public AdapterRecyclerviewForBloodDoner(Context context, ArrayList<DataFormateForRecyclerview> items)
    {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterRecyclerviewForBloodDoner.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout_for_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerviewForBloodDoner.MyViewHolder holder, int position)
    {
        DataFormateForRecyclerview object=items.get(position);
        holder.donarname.setText(object.getName());
        holder.bloodgroup.setText(object.getBloodgroup());
        holder.blooddetails.setText(object.getMobilenumber()+"  "+object.getLastdonation());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView donarname,blooddetails,bloodgroup;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            bloodgroup=itemView.findViewById(R.id.blood_group_sample_layout);
            donarname=itemView.findViewById(R.id.name_of_doctor_sample_layout);
            blooddetails=itemView.findViewById(R.id.details_of_doctor_sample_layout);
        }
    }
}
