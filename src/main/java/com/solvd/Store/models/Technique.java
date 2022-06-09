package com.solvd.Store.models;

public class Technique extends BaseEntity {
    private String name;
    private PhoneStore phoneStore;
    private Model model;
    private Year year;
    private Price price;
    private Country country;

    private Technique(){

    }

    public Technique(String name, PhoneStore phoneStore, Model model, Year year, Price price, Country country) {
        this.name = name;
        this.phoneStore = phoneStore;
        this.model = model;
        this.year = year;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneStore getPhoneStore() {
        return phoneStore;
    }

    public void setPhoneStore(PhoneStore phoneStore) {
        this.phoneStore = phoneStore;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Technique{" +
                "name='" + name + '\'' +
                ", phoneStore=" + phoneStore +
                ", model=" + model +
                ", year=" + year +
                ", price=" + price +
                ", country=" + country +
                '}';
    }
}
