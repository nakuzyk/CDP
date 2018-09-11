package com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies;

public class Cookies extends Confection {
    private int count;

    public Cookies(String name, double cost, double weight, String type, int count) {
        super(name, cost, weight, type);
    }

    public int GetCount(){
        return count;
    }

}
