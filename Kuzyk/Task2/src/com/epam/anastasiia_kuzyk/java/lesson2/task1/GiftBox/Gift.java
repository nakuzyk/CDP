package com.epam.anastasiia_kuzyk.java.lesson2.task1.GiftBox;

import java.util.Scanner;

import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Cookies;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Confection;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Marshmallow;
import com.epam.anastasiia_kuzyk.java.lesson2.task1.Candies.Chocolate;


public class Gift {

    private static Integer iterator = 0;
    private static Integer volume = 6;
    private Confection[] list = new Confection[volume];

    public void addConfection(Confection confection) {
        if (iterator < volume - 1)
            list[iterator++] = confection;
        else {
            doubleList();
            list[iterator++] = confection;
        }
    }

    public void removeConfection(int i) {
        if (iterator < i) {
            return;
        }
        for(;i < iterator; i++){
            list[i] = list[i+1];
        }
        list[iterator--] = null;
    }

    public void doubleList(){
        volume*=2;
        Confection[] newList =  new Confection[volume];
        System.arraycopy(list, 0, newList, 0, iterator);
        setList(newList);
    }


    /**
     * First method. Returns the total cost of all items from list (ArrayList
     * <Confection> list)
     */

    public double getFinalWeight(double sum) {
        for (Confection x : list) {
            if (x != null ) {
                sum += x.getWeight();
            }
        }
        return sum;
    }

    /**
     * Second method. Returns candy from list based on users entered info. Cost
     * of this candy will be more or equal A and less or equal B. A and B values
     * user types in console.
     */

    public void findElementByCost() {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();
        StringBuilder item = findCandyByCost(a, b);
        System.out.println("\nYour candies are: " + item);
    }

    public StringBuilder findCandyByCost(double a, double b) {
        StringBuilder candy = new StringBuilder();
        for (Confection x : list) {
            if (x != null ) {
                if ((x.getCost() >= a && x.getCost() <= b) || (x.getCost() >= b && x.getCost() <= a)) {
                    candy.append(x.getName()).append("(").append(x.getType()).append("), ");
                }
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

    public void displayArrays() {
        int i = 1;
        //System.out.printf("ID: " + " NAME:    " + "   COST: " + "     WEIGHT:  " + "TYPE:");
        System.out.println("ID: " + " NAME:    " + "   COST: " + "     WEIGHT:  " + "   TYPE:");
        for (Confection x : list) {
           if (x != null ) {
               System.out.println(i + ".   " + x.getName() + "     " + x.getCost() + "        " + x.getWeight()
                       + "      " + x.getType());
               i++;
           }
        }
    }

    public void createArray() {
        addConfection(new Chocolate("Snikers ", 2.99, 50, "Chocolate", "Hazelnut"));
        addConfection(new Chocolate("Mars    ", 2.51, 45, "Chocolate", "Meadows"));
        addConfection(new Marshmallow("Zephyr   ", 6.10, 80.1, "Marshmallow", "Blueberry"));
        addConfection(new Marshmallow("American ", 8.50, 95.5, "Marshmallow", "Strawberry"));
        addConfection(new Cookies("Sand    ", 1.99, 30, "Cookie", 5));
        addConfection(new Cookies("Cracker ", 3.99, 50.5, "Cookie", 10));
    }

    public Confection[] getList() {
        return list;
    }

    public void setList(Confection[] list) {
        this.list = list;
    }

    /**
     * Text messages
     */

    public static void showTheLastInfoMessage() {
        System.out.println(
                "\nAnd now let's find some candies from gift-box by thier cost.\nPlease enter first and last numbers of range");
    }
}
