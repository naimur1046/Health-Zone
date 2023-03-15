package com.example.myapplication;

import android.widget.ImageView;

public class DataFormateForRecyclerview
{
    String bloodgroup;
    String name;
    String lastdonation;
    String mobilenumber;
    public DataFormateForRecyclerview(String bloodgroup, String name, String lastdonation, String mobilenumber) {
        this.bloodgroup = bloodgroup;
        this.name = name;
        this.lastdonation = lastdonation;
        this.mobilenumber = mobilenumber;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getName() {
        return name;
    }

    public String getLastdonation() {
        return lastdonation;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastdonation(String lastdonation) {
        this.lastdonation = lastdonation;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
