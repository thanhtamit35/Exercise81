package com.example.myapplication;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Employee implements Serializable {
    private String fullName;
    private String gender;
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(String fullName, String gender, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
    }

    @NonNull
    @Override
    public String toString() {
        return fullName + '-' + gender + '-' + address + '\n';
    }
}

