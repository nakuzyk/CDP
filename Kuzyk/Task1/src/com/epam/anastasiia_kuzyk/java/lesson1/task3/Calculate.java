package com.epam.anastasiia_kuzyk.java.lesson1.task3;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = enter.nextInt();
        System.out.println("Введите второе число: ");
        int b = enter.nextInt();
        System.out.println("Введите арифметическую операцию (+,-,* или /): ");
        String op = enter.next();

        switch (op) {
            case "+":
                System.out.println(SumOperation(a, b));
                break;
            case  "-":
                System.out.println(SubOperation(a, b));;
                break;
            case "*":
                System.out.println(MultOperation(a, b));
                break;
            case "/":
                System.out.println(DivOperation(a, b));
                break;
                default:
                    System.out.println("Это не арифметическая операция");
                    break;
        }
    }

    static int SumOperation(int a, int b){
        return a + b;
    }

    static int SubOperation(int a, int b){
        return a - b;
    }

    static int MultOperation(int a, int b){
        return a * b;
    }

    static int DivOperation(int a, int b){
        if (b == 0)
        {
            return 0;
        }
        return a / b;
    }
}
