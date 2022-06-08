package com.solvd.Store.models;

import java.util.List;

public class Price {
    private double price;
    private List<Technique> techniques;

    public Price() {
    }

    public Price(double price, List<Technique> techniques) {
        this.price = price;
        this.techniques = techniques;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", techniques=" + techniques +
                '}';
    }
}
