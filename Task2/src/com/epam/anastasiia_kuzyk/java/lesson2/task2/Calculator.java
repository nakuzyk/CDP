package com.epam.anastasiia_kuzyk.java.lesson2.task2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Calculator.
 */
public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    private Map<Character, Operation> operationMap = new HashMap<>();

    /**
     * Instantiates a new Calculator.
     *
     * @param operand1  the operand 1
     * @param operand2  the operand 2
     * @param operation the operation
     */
    public Calculator(double operand1, double operand2, char operation) {

        operationMap.put('+', new Addition());
        operationMap.put('-', new Substraction());
        operationMap.put('*', new Multiplication());
        operationMap.put('/', new Division());
    }

    /**
     * Make calculation double.
     *
     * @param operand1  the operand 1
     * @param operand2  the operand 2
     * @param operation the operation
     * @return the double
     */
    public double makeCalculation(double operand1, double operand2, char operation) {

        Operation operationMapValue = operationMap.getOrDefault(operation,new NoOperationFound(operation));
        return operationMapValue.calculateResult(operand1, operand2);
    }

    /**
     * Start.
     *
     * @throws InputMismatchException the input mismatch exception
     */
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
