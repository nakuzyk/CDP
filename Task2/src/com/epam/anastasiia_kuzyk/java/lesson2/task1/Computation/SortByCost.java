package com.epam.anastasiia_kuzyk.java.lesson2.task1.Computation;

import java.util.Comparator;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;

/**
 * The type Sort by cost.
 */
public class SortByCost implements Comparator<Confection> {
    public int compare(Confection o1, Confection o2) {
        if (o1 != null && o2 != null) {
            double c1 = o1.getCost();
            double c2 = o2.getCost();
            if (c1 < c2) {
                return -1;
            }
            if (c1 > c2) {
                return 1;
            }
            return 0;
        } else {
            return (o1 == null && o2 == null)
                    ? 0
                    : (o1 == null) ? 1 : -1;
        }
    }
}
  

//    public int compare(Confection o1, Confection o2) {
//        double c1 = o1.getCost();
//        double c2 = o2.getCost();
//        if (c1 < c2) {
//            return -1;
//        }
//        if (c1 > c2) {
//            return 1;
//        }
//        return 0;
//
//    }


