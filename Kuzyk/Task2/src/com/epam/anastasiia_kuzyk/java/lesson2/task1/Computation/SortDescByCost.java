package com.epam.anastasiia_kuzyk.java.lesson2.task1.Computation;

import java.util.Comparator;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;

public class SortDescByCost implements Comparator<Confection>{
    public int compare(Confection o1, Confection o2) {
        double c1 = o1.getCost();
        double c2 = o2.getCost();
        if (c1 < c2) {
            return 1;
        }
        if (c1 > c2) {
            return -1;
        }
        return 0;

    }
}
