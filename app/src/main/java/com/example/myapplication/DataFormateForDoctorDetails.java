package com.example.myapplication;

public class DataFormateForDoctorDetails
{
    String doctor_name;
    String doctor_chember;
    String doctor_details;
    String doctor_schedule;
    String doctor_phone_number;

    public void setDoctor_phone_number(String doctor_phone_number) {
        this.doctor_phone_number = doctor_phone_number;
    }

    public DataFormateForDoctorDetails(String doctor_name, String doctor_chember, String doctor_details, String doctor_schedule, String doctor_phone_number) {
        this.doctor_name = doctor_name;
        this.doctor_chember = doctor_chember;
        this.doctor_details = doctor_details;
        this.doctor_schedule = doctor_schedule;
        this.doctor_phone_number = doctor_phone_number;
    }

    public String getDoctor_phone_number() {
        return doctor_phone_number;
    }

    public void setDoctor_schedule(String doctor_schedule) {
        this.doctor_schedule = doctor_schedule;
    }

    public String getDoctor_schedule() {
        return doctor_schedule;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDoctor_chember() {
        return doctor_chember;
    }

    public String getDoctor_details() {
        return doctor_details;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public void setDoctor_chember(String doctor_chember) {
        this.doctor_chember = doctor_chember;
    }

    public void setDoctor_details(String doctor_details) {
        this.doctor_details = doctor_details;
    }
}
