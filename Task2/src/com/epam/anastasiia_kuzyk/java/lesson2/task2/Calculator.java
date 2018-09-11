package com.epam.anastasiia_kuzyk.java.lesson2.task2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
//    private char operation;
//    private double operand1;
//    private double operand2;
    private Map<Character, Operation> operationMap = new HashMap<>();

    public Calculator(double operand1, double operand2, char operation) {
//        this.operand1 = operand1;
//        this.operand2 = operand2;
//        this.operation = operation;

        operationMap.put('+', new Addition());
        operationMap.put('-', new Substraction());
        operationMap.put('*', new Multiplication());
        operationMap.put('/', new Division());
    }

    public double makeCalculation(double operand1, double operand2, char operation) {

        Operation operationMapValue = operationMap.getOrDefault(operation,new NoOperationFound(operation));
        return operationMapValue.calculateResult(operand1, operand2);
    }

    static public void start() throws InputMismatchException {
        System.out.println("Write two numbers and +, -, * or / sign");
        char operator = '0';
        double firstNum = 0;
        double secondNum = 0;
            firstNum = scanner.nextDouble();
            secondNum = scanner.nextDouble();
            operator = scanner.next().charAt(0);

        Calculator calculator = new Calculator(firstNum, secondNum,    operator);
        System.out.println(calculator.makeCalculation(firstNum,secondNum, operator));
    }
}
