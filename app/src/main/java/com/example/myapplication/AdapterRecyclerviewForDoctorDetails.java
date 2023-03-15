package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerviewForDoctorDetails extends RecyclerView.Adapter<AdapterRecyclerviewForDoctorDetails.MyViewHolder>
{
    Context context;
    ArrayList<DataFormateForDoctorDetails> items;
    public AdapterRecyclerviewForDoctorDetails(Context context, ArrayList<DataFormateForDoctorDetails> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public AdapterRecyclerviewForDoctorDetails.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout_doctor_details,parent,false);
        return new AdapterRecyclerviewForDoctorDetails.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerviewForDoctorDetails.MyViewHolder holder, int position)
    {
        DataFormateForDoctorDetails dataformate=items.get(position);
        holder.doctor_name.setText(dataformate.getDoctor_name());
        holder.doctor_details.setText(dataformate.doctor_phone_number+"  ,"+dataformate.doctor_chember);
        holder.doctor_phone_number.setText(dataformate.doctor_schedule);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BookApoinmentDoctor.class);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView doctor_name,doctor_details,doctor_phone_number;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor_name=itemView.findViewById(R.id.name_of_doctor_sample_layout);
            doctor_details=itemView.findViewById(R.id.details_of_doctor_sample_layout);
            doctor_phone_number=itemView.findViewById(R.id.doctor_contact_number);
            linearLayout=itemView.findViewById(R.id.sample_layout_for_doctor_details);
        }
    }
}
