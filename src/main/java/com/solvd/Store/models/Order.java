package com.solvd.Store.models;

public class Order extends BaseEntity {
    private double price;
    private PhoneStore phoneStore;
    private Client client;

    public Order() {
    }

    public Order(double price, PhoneStore phoneStore, Client client) {
        this.price = price;
        this.phoneStore = phoneStore;
        this.client = client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PhoneStore getPhoneStore() {
        return phoneStore;
    }

    public void setPhoneStore(PhoneStore phoneStore) {
        this.phoneStore = phoneStore;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "price= " + price +
                ", phoneStore= " + phoneStore +
                ", client= " + client +
                '}';
    }
}
