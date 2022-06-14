package com.solvd.store.models;

import java.util.List;

public class WorkersExperience extends BaseEntity {
    private int experience;
    private List<Worker> workers;

    public WorkersExperience() {
    }

    public WorkersExperience(int experience, List<Worker> workers) {
        this.experience = experience;
        this.workers = workers;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
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
