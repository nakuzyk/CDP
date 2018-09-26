package com.epam.anastasiia_kuzyk.java.lesson2.task2;

import java.util.InputMismatchException;

public class CalcApp {


    public static void main(String[] args) {
        try {
            Calculator.start();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
}




