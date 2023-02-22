package com.example.hotelapplication;

public class RoomServiceOrder {

    private String name, roomNumber, phoneNumber, order, paymentType;

    public RoomServiceOrder() {

    }

    public RoomServiceOrder(String name, String roomNumber, String phoneNumber, String order, String paymentType) {
        this.name = name;
        this.roomNumber=roomNumber;
        this.phoneNumber=phoneNumber;
        this.order=order;
        this.paymentType=paymentType;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


}
