package com.epam.anastasiia_kuzyk.java.lesson2.task2;

public class Division implements Operation {

    @Override
    public double calculateResult(double left, double right) {
        if (right == 0) {
            System.out.println("You can not divide by zero");
        }
        return left / right;
    }
}
