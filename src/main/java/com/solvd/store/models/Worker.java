package com.solvd.store.models;

public class Worker extends BaseEntity {
    private String name;
    private String surname;
    private WorkersExperience workersExperience;
    private WorkersPosition workersPosition;
    private PhoneStore phoneStore;

    public Worker() {
    }

    public Worker(String name, String surname, WorkersExperience workersExperience, WorkersPosition workersPosition, PhoneStore phoneStore) {
        this.name = name;
        this.surname = surname;
        this.workersExperience = workersExperience;
        this.workersPosition = workersPosition;
        this.phoneStore = phoneStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public WorkersExperience getWorkersExperience() {
        return workersExperience;
    }

    public void setWorkersExperience(WorkersExperience workersExperience) {
        this.workersExperience = workersExperience;
    }

    public WorkersPosition getWorkersPosition() {
        return workersPosition;
    }

    public void setWorkersPosition(WorkersPosition workersPosition) {
        this.workersPosition = workersPosition;
    }

    public PhoneStore getPhoneStore() {
        return phoneStore;
    }

    public void setPhoneStore(PhoneStore phoneStore) {
        this.phoneStore = phoneStore;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workersExperience=" + workersExperience +
                ", workersPosition=" + workersPosition +
                ", phoneStore=" + phoneStore +
                '}';
    }
}
