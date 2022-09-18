package com.daisy.DaisySheCodes.response;

public class OrderResponse {
    public Long id;
    public String customer;
    public String restaurant;
    public String pickUpPoint;
    public String destination;
    public Long payment;
    public Long total;
    public String createdOn;

    public OrderResponse(Long id, String customer, String restaurant, String pickUpPoint, String destination, Long payment, Long total, String createdOn) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.pickUpPoint = pickUpPoint;
        this.destination = destination;
        this.payment = payment;
        this.total = total;
        this.createdOn = createdOn;
    }

    public OrderResponse(Long id, String name, String address, String address1, Long amount, Long total, String date) {
    }
}
