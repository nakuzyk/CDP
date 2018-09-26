package com.epam.anastasiia_kuzyk.java.lesson2.task2;

public class Addition implements Operation {

    @Override
    public double calculateResult(double left, double right){
        return left + right;
    }
}
