package com.solvd.Store.models;

public class PhoneStore extends BaseEntity {
    private String name;
    private StoreAddress storeAddress;
    private StoresSquare storesSquare;

    public PhoneStore() {
    }

    public PhoneStore(String name, StoreAddress storeAddress, StoresSquare storesSquare) {
        this.name = name;
        this.storeAddress = storeAddress;
        this.storesSquare = storesSquare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(StoreAddress storeAddress) {
        this.storeAddress = storeAddress;
    }

    public StoresSquare getStoresSquare() {
        return storesSquare;
    }

    public void setStoresSquare(StoresSquare storesSquare) {
        this.storesSquare = storesSquare;
    }

    @Override
    public String toString() {
        return "PhoneStore{" +
                "name='" + name + '\'' +
                ", storeAddress=" + storeAddress +
                ", storesSquare=" + storesSquare +
                '}';
    }
}

