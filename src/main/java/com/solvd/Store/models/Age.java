package com.solvd.Store.models;

import java.util.List;

public class Age {
    private int age;
    private List<Client> clients;

    public Age(int age, List<Client> clients) {
        this.age = age;
        this.clients = clients;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                ", clients=" + clients +
                '}';
    }
}
