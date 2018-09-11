package com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies;

public class Marshmallow extends Confection{
    public String flavor;

    public Marshmallow(String name, double cost, double weight, String type, String flavor) {
        super(name, cost, weight, type);
    }

    public String getFlavor() {
        return  flavor;
    }
}
