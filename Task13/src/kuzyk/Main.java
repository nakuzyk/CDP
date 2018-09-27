package kuzyk;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadRunner t = new ThreadRunner();
        t.minimumRangeInput();
        t.maximumRangeInput();
        t.count();
        t.creatingThreadPool();
        t.print();
    }
}
