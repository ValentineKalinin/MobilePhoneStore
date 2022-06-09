package com.solvd.Store.models;

import java.util.List;

public class Model extends BaseEntity {
    private String model;
    private List<Technique> Techniques;

    public Model() {
    }

    public Model(String model, List<Technique> techniques) {
        this.model = model;
        Techniques = techniques;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Technique> getTechniques() {
        return Techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        Techniques = techniques;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                ", Techniques=" + Techniques +
                '}';
    }
}
