package com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies;

/**
 * The type Cookies.
 */
public class Cookies extends Confection {
    private int count;

    /**
     * Instantiates a new Cookies.
     *
     * @param name   the name
     * @param cost   the cost
     * @param weight the weight
     * @param type   the type
     * @param count  the count
     */
    public Cookies(String name, double cost, double weight, String type, int count) {
        super(name, cost, weight, type);
    }

    /**
     * Get count int.
     *
     * @return the int
     */
    public int GetCount(){
        return count;
    }

}
