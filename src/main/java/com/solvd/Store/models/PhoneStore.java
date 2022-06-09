package com.solvd.Store.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PhoneStore")
@XmlType(propOrder = {"id", "name", "storeAddress", "storesSquare"})
public class PhoneStore {
    private Long id;
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

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setStoreAddress(StoreAddress storeAddress) {
        this.storeAddress = storeAddress;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }

    @XmlElement
    public void setStoresSquare(StoresSquare storesSquare) {
        this.storesSquare = storesSquare;
    }

    public StoresSquare getStoresSquare() {
        return storesSquare;
    }

    @Override
    public String toString() {
        return "PhoneStore{" +
                "id=" + id +
                ", name=" + name +
                ", storeAddress=" + storeAddress +
                ", storesSquare=" + storesSquare +
                '}';
    }

}

