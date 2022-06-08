package com.solvd.Store.models;

import java.util.List;

public class WorkersPosition {
    private String position;
    private List<Worker> workers;

    public WorkersPosition() {
    }

    public WorkersPosition(String position, List<Worker> workers) {
        this.position = position;
        this.workers = workers;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "WorkersPosition{" +
                "position='" + position + '\'' +
                ", workers=" + workers +
                '}';
    }
}
