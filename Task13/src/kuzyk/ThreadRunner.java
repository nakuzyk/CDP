package kuzyk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadRunner extends Thread {
    private static AtomicInteger minInt = new AtomicInteger(0);
    private static Integer max = 0;
    private static int count = 0;

    public Scanner scanner = new Scanner(System.in);

    private static List<Integer> newList = Collections.synchronizedList(new ArrayList<>());

    public void run() {
        int number;

        while ((number = minInt.getAndIncrement()) <= max) {
            System.out.println(Thread.currentThread().getName());
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

    public void minimumRangeInput() {
        System.out.println("Min");
        Integer min = scanner.nextInt();
        this.minInt = new AtomicInteger(min);
    }

    public void maximumRangeInput() {
        System.out.println("Max");
        this.max = scanner.nextInt();

    }

    public void count() {
        System.out.println("Count");
        this.count = scanner.nextInt();
    }

    public void creatingThreadPool() throws InterruptedException {
        Thread[] threads = new Thread[count];

        // threads[x].join();
        for (int x = 0; x < threads.length; x++) {
            (threads[x] = new ThreadRunner()).start();
            //(threads[x] = new Thread(new ThreadRunner())).start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void print() {
        System.out.println(newList);
    }
}
