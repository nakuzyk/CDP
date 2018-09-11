package com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies;

/**
 * The type Marshmallow.
 */
public class Marshmallow extends Confection{
    /**
     * The Flavor.
     */
    public String flavor;

    /**
     * Instantiates a new Marshmallow.
     *
     * @param name   the name
     * @param cost   the cost
     * @param weight the weight
     * @param type   the type
     * @param flavor the flavor
     */
    public Marshmallow(String name, double cost, double weight, String type, String flavor) {
        super(name, cost, weight, type);
    }

    /**
     * Gets flavor.
     *
     * @return the flavor
     */
    public String getFlavor() {
        return  flavor;
    }
}
