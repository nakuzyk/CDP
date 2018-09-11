package com.epam.anastasiia_kuzyk.java.lesson2.task1.Computation;

import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.GiftBox.Gift;

import java.util.Arrays;

public class GiftForTheNewYear {
    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.createArray();
        System.out.println("Creating a collection");

        gift.displayArrays();

        double res = gift.getFinalWeight(0);
        System.out.println("\n2. Total weight of all items is: " + res + "\n");
        System.out.println("Final weight is calculated: " + res);

        System.out.println("3. Sorted list by Cost:\n");
        Arrays.sort(gift.getList(), new SortByCost());
        gift.displayArrays();
        System.out.println();
        Arrays.sort(gift.getList(), new SortDescByCost());
        gift.displayArrays();
        System.out.println("Sorting was successful");

        Gift.showTheLastInfoMessage();
        gift.findElementByCost();
        System.out.println("No errors during searching for candy");
    }
}
