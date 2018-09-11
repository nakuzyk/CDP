package com.epam.anastasiia_kuzyk.java.lesson2.task1.GiftBox;

import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;
import  java.util.ArrayList;

public interface GiftBox {
    public double getFinalCost(double sum);
    public void findElementByCost();
    public void displayArrays();
//    public double getFinalCost(ArrayList<Confection> list, double sum);
//    public void findElementByCost(ArrayList<Confection> list);
//    public void displayCollection(ArrayList<Confection> list);
}
