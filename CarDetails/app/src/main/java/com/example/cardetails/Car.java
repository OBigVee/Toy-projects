package com.example.cardetails;

public class Car {
    private String brand;
    private String model;
    private String ownerName;
    private String ownerPhoneNo;

    public Car(String brand, String model, String ownerName, String ownerPhoneNo) {
        this.brand = brand;
        this.model = model;
        this.ownerName = ownerName;
        this.ownerPhoneNo = ownerPhoneNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNo() {
        return ownerPhoneNo;
    }

    public void setOwnerPhoneNo(String ownerPhoneNo) {
        this.ownerPhoneNo = ownerPhoneNo;
    }



}
