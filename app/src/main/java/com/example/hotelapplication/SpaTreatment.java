//Student Name: Megan Cash
//Student Number: C19317723
//Assignment 3 - Hotel Application
package com.example.hotelapplication;

public class SpaTreatment {

    //Variables
    private String name, roomNumber, number, treatment,time, date, paymentType;

    //Constructor
    public SpaTreatment() {

    }

    public SpaTreatment(String name, String roomNumber, String number, String treatment,String time, String date, String paymentType) {
        this.name = name;
        this.roomNumber=roomNumber;
        this.number=number;
        this.treatment=treatment;
        this.time=time;
        this.date=date;
        this.paymentType=paymentType;

    }
    //Getter and Setter Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
