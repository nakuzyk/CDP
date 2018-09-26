package kuzyk.task3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Connector {
    public static void main(String[] args) {
        String fileName = "confection.dat";

        Gift gift = new Gift();
        gift.addConfection(new Chocolate("Snikers ", 2.99, 50, "Chocolate", "Hazelnut"));
        gift.addConfection(new Chocolate("Mars    ", 2.51, 45, "Chocolate", "Meadows"));
        gift.addConfection(new Marshmallow("Zephyr   ", 6.10, 80.1, "Marshmallow", "Blueberry"));
        gift.addConfection(new Marshmallow("American ", 8.50, 95.5, "Marshmallow", "Strawberry"));
        gift.addConfection(new Cookies("Sand    ", 1.99, 30, "Cookie", 5));
        gift.addConfection(new Cookies("Cracker ", 3.99, 50.5, "Cookie", 10));
        gift.createArray();
        System.out.println("Creating a collection");

        gift.displayArrays();

        double res = gift.getFinalWeight(0);
        System.out.println("\n2. Total weight of all items is: " + res + "\n");
        System.out.println("Final weight is calculated: " + res);

        System.out.println("No errors during searching for candy");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(gift);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
