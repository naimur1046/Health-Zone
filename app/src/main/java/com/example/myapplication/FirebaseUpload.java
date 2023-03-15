package com.example.myapplication;

public class FirebaseUpload
{
    private String Password;
    private String UserName;
    private String Email;
    private String PhoneNumber;

    public FirebaseUpload() {

    }

    public FirebaseUpload(String password, String userName, String email, String phoneNumber) {
        Password = password;
        UserName = userName;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

}
