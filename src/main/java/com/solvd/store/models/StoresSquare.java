package com.solvd.store.models;

import java.util.List;

public class StoresSquare extends BaseEntity {
    private double square;
    private List<PhoneStore> phoneStores;

    public StoresSquare() {
    }

    public StoresSquare(double square, List<PhoneStore> phoneStores) {
        this.square = square;
        this.phoneStores = phoneStores;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public List<PhoneStore> getPhoneStores() {
        return phoneStores;
    }

    public void setPhoneStores(List<PhoneStore> phoneStores) {
        this.phoneStores = phoneStores;
    }

    @Override
    public String toString() {
        return "StoresSquare{" +
                "square=" + square +
                ", phoneStores=" + phoneStores +
                '}';
    }
}
