package com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies;

public class Chocolate extends Confection {
    private String filling;

    public Chocolate(String name, double cost, double weight, String type, String filling) {
        super(name, cost, weight, type);
    }

    public String getFilling() {
        return filling;
    }
}
