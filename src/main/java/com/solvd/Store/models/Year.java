package com.solvd.Store.models;

import java.util.List;

public class Year {
    private int year;
    private List<Technique> techniques;

    public Year() {
    }

    public Year(int year, List<Technique> techniques) {
        this.year = year;
        this.techniques = techniques;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                ", techniques=" + techniques +
                '}';
    }
}
