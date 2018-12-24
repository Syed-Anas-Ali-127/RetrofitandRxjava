package com.example.android.retrofit;

/**
 * Created by Syed Anas Ali on 22-Dec-18.
 */

public class GetnSet {

    private String name;
    private String fullname;
    private String rollno;
    private String phone;

    public GetnSet(String name, String fullname, String rollno, String phone) {
        this.name = name;
        this.fullname = fullname;
        this.rollno = rollno;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRollno() {
        return rollno;
    }

    public String getPhone() {
        return phone;
    }
}
