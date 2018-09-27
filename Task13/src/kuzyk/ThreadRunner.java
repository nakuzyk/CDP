package kuzyk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRunner implements Runnable {
    private Integer min;
    private AtomicInteger minInt;
    private Integer max;
    private int count;
    public Scanner scanner = new Scanner(System.in);

    List<Integer> newList = Collections.synchronizedList(new ArrayList<Integer>());

    @Override
    public void run() {
        int number;
        while ((number = minInt.getAndIncrement()) <= max) {
            if (checkSimple(number)) {
                newList.add(number);
            }
        }
    }

    public static boolean checkSimple(int number) {
        boolean result = true;
        for (int i = 2; i <= (Math.sqrt(number)); i++) {
            if (number % i == 0) {
                result = false;
            }
        }
        return result;
    }

    public Integer minimumRangeInput() {
        System.out.println("Min");
        min = scanner.nextInt();
        minInt = new AtomicInteger(min);
        return min;
    }

    public Integer maximumRangeInput() {
        System.out.println("Max");
        max = scanner.nextInt();
        return max;
    }

    public Integer count() {
        System.out.println("Count");
        count = scanner.nextInt();
        return count;
    }

    public void creatingThreadPool() {
        for (int i = 1; i <= count; i++) {
            run();
        }
    }

    public void print() {
        System.out.println(newList);
    }
}