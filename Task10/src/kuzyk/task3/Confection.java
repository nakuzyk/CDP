package kuzyk.task3;

import java.io.Serializable;

/**
 * The type Confection.
 */
public class Confection implements Serializable {
    private String name;
    private double cost;
    private double weight;
    private String type;

    /**
     * Instantiates a new Confection.
     *
     * @param name   the name
     * @param cost   the cost
     * @param weight the weight
     * @param type   the type
     */
    public Confection(String name, double cost, double weight, String type) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.type = type;
    }

    /**
     * Instantiates a new Confection.
     */
    public Confection() {
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        if (name.isEmpty() || name == null) {
            System.out.println("Incorrect name data. Field is empty");
        }
        return name;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public double getCost() {
        if (cost < 0) {
            System.out.println("Incorrect weight data (negative or missing digits)");
        }
        return  cost;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        if (weight <= 0) {
            System.out.println("Negative Weigt value");
        }
        return weight;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        if (type.isEmpty() || type == null) {
            System.out.println("Incorrect name data. Field is empty");
            throw new IllegalArgumentException("Check the type! Type field cannot be empty");
        }
        return type;

    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

}
