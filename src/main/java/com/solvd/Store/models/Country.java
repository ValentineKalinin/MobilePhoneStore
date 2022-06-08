package com.solvd.Store.models;

import java.util.List;

public class Country {
    private String country;
    private List<Technique> Techniques;

    public Country() {
    }

    public Country(String country, List<Technique> techniques) {
        this.country = country;
        Techniques = techniques;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Technique> getTechniques() {
        return Techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        Techniques = techniques;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", Techniques=" + Techniques +
                '}';
    }
}
