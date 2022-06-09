package com.solvd.Store.models;

import java.util.List;

public class WorkersExperience extends BaseEntity {
    private String experience;
    private List<Worker> workers;

    public WorkersExperience() {
    }

    public WorkersExperience(String experience, List<Worker> workers) {
        this.experience = experience;
        this.workers = workers;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "WorkersExperience{" +
                "experience='" + experience + '\'' +
                ", workers=" + workers +
                '}';
    }
}
