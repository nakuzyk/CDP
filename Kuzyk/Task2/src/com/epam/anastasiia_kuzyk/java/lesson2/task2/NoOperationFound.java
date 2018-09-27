package com.epam.anastasiia_kuzyk.java.lesson2.task2;

import java.util.InputMismatchException;

public class NoOperationFound implements Operation {
    private char sign;
    NoOperationFound(char sign){
        this.sign = sign;
    }

    @Override
    public double calculateResult(double left, double right) {
        throw new InputMismatchException("Invalid operator sign: " + sign);
    }
}
