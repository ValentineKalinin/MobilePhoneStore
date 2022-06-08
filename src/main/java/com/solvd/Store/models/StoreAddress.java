package com.solvd.Store.models;

import java.util.List;

public class StoreAddress {
    private String address;
    private List<PhoneStore> phoneStores;

    public StoreAddress() {
    }

    public StoreAddress(String address, List<PhoneStore> phoneStores) {
        this.address = address;
        this.phoneStores = phoneStores;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneStore> getPhoneStores() {
        return phoneStores;
    }

    public void setPhoneStores(List<PhoneStore> phoneStores) {
        this.phoneStores = phoneStores;
    }

    @Override
    public String toString() {
        return "StoreAddress{" +
                "address='" + address + '\'' +
                ", phoneStores=" + phoneStores +
                '}';
    }
}
