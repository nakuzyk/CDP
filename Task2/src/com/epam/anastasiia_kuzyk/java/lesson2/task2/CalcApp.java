package com.epam.anastasiia_kuzyk.java.lesson2.task2;

import java.util.InputMismatchException;

/**
 * The type Calc app.
 */
public class CalcApp {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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




