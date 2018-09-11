package com.epam.anastasiia_kuzyk.java.lesson2.task1.GiftBox;

import java.util.Arrays;
import java.util.Scanner;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Cookies;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Marshmallow;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Chocolate;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Computation.SortByCost;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Computation.SortDescByCost;

public class Gift {

    public static void createBox() {
        Gift gift = new Gift();
        Confection[] list = gift.createArray();
        System.out.println("Creating a collection");

        gift.displayArrays(list);

        double res = gift.getFinalWeight(list, 0);
        System.out.println("\n2. Total weight of all items is: " + res + "\n");
        System.out.println("Final weight is calculated: " + res);

        System.out.println("3. Sorted list by Cost:\n");
        Arrays.sort(list, new SortByCost());
        gift.displayArrays(list);
        System.out.println();
        Arrays.sort(list, new SortDescByCost());
        gift.displayArrays(list);
        System.out.println("Sorting was successful");

        showTheLastInfoMessage();
        gift.findElementByCost(list);
        System.out.println("No errors during searching for candy");
    }

    /**
     * First method. Returns the total cost of all items from list (ArrayList
     * <Confection> list)
     */

    public double getFinalWeight(Confection[] list, double sum) {
        for (Confection x : list) {
            sum += x.getWeight();
        }
        return sum;
    }

    /**
     * Second method. Returns candy from list based on users entered info. Cost
     * of this candy will be more or equal A and less or equal B. A and B values
     * user types in console.
     */

    public void findElementByCost(Confection[] list) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();
        StringBuilder item = findCandyByCost(a, b, list);
        System.out.println("\nYour candies are: " + item);
    }

    public StringBuilder findCandyByCost(double a, double b, Confection[] list) {
        StringBuilder candy = new StringBuilder();
        for (Confection x : list) {
            if ((x.getCost() >= a && x.getCost() <= b) || (x.getCost() >= b && x.getCost() <= a)) {
                candy.append(x.getName()).append("(").append(x.getType()).append("), ");
            }
        }
        if (a < 0 || b < 0) {

            throw new IllegalArgumentException("Check entered numbers. They cannot be negative");
        }
        return candy;
    }

    /**
     * Third method. Displays collection based on entered objects and their
     * parameters.
     */

    public void displayArrays(Confection[] list) {
        int i = 1;
        //System.out.printf("ID: " + " NAME:    " + "   COST: " + "     WEIGHT:  " + "TYPE:");
        System.out.println("ID: " + " NAME:    " + "   COST: " + "     WEIGHT:  " + "   TYPE:");
        for (Confection x : list) {
            System.out.println(i + ".   " + x.getName() + "     " + x.getCost() + "        " + x.getWeight()
                        + "      " + x.getType());
            i++;
        }
    }

    public Confection[] createArray() {
        Confection[] list = new Confection[6];

        list[0] = new Chocolate("Snikers ", 2.99, 50, "Chocolate", "Hazelnut");
        list[1] = new Chocolate("Mars    ", 2.51, 45, "Chocolate", "Meadows");
        list[2] = new Marshmallow("Zephyr   ", 6.10, 80.1, "Marshmallow", "Blueberry");
        list[3] = new Marshmallow("American ", 8.50, 95.5, "Marshmallow", "Strawberry");
        list[4] = new Cookies("Sand    ", 1.99, 30, "Cookie", 5);
        list[5] = new Cookies("Cracker ", 3.99, 50.5, "Cookie", 10);

        return list;
    }

    /** Text messages */

    public static void showTheLastInfoMessage(){
        System.out.println(
                "\nAnd now let's find some candies from gift-box by thier cost.\nPlease enter first and last numbers of range");
    }
}
