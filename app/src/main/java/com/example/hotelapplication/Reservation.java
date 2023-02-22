//Student Name: Megan Cash
//Student Number: C19317723
//ASSIGNMENT 3
package com.example.hotelapplication;

public class Reservation {

    //Variables - User is defined as having an room number, password, name and phone number, number of guests, date and time.
    public String fullName1, phoneNumber1, roomNumber1, numberOfGuests1, date1, time1;

    public Reservation() {

    }

    public Reservation(String fullName1, String phoneNumber1, String roomNumber1, String numberOfGuests1, String date1, String time1) {

        this.fullName1=fullName1;
        this.phoneNumber1=phoneNumber1;
        this.roomNumber1=roomNumber1;
        this.numberOfGuests1=numberOfGuests1;
        this.date1=date1;
        this.time1=time1;
    }

    //Getter and Setter Methods

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getNumberOfGuests1() {
        return numberOfGuests1;
    }

    public void setNumberOfGuests1(String numberOfGuests1) {
        this.numberOfGuests1 = numberOfGuests1;
    }

    public String getFullName1() {
        return fullName1;
    }

    public void setFullName1(String fullName1) {
        this.fullName1 = fullName1;
    }

    public String getRoomNumber1() {
        return roomNumber1;
    }

    public void setRoomNumber1(String roomNumber1) {
        this.roomNumber1 = roomNumber1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}

