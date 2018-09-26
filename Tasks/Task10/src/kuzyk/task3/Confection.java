package kuzyk.task3;

import java.io.Serializable;

public class Confection implements Serializable {
    private String name;
    private double cost;
    private double weight;
    private String type;

    public Confection(String name, double cost, double weight, String type) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.type = type;
    }

    public Confection() {
    }

    public String getName() {
        if (name.isEmpty() || name == null) {
            System.out.println("Incorrect name data. Field is empty");
        }
        return name;
    }

    public double getCost() {
        if (cost < 0) {
            System.out.println("Incorrect weight data (negative or missing digits)");
        }
        return  cost;
    }

    public double getWeight() {
        if (weight <= 0) {
            System.out.println("Negative Weigt value");
        }
        return weight;
    }

    public String getType() {
        if (type.isEmpty() || type == null) {
            System.out.println("Incorrect name data. Field is empty");
            throw new IllegalArgumentException("Check the type! Type field cannot be empty");
        }
        return type;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

}
