package kuzyk;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

/**
 * The type Main.
 */
public class Main {
    /**
     * The constant DESC.
     */
    public static boolean DESC = true;
    /**
     * The Scanner.
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        OperationWithCollection operation1 = new OperationWithCollection();
        FileReadArg fileReadArg = new FileReadArg();
        fileReadArg.fileReader();
        LinkedList<String> stringArray = fileReadArg.addToCollection(fileReadArg.fileReader());

        LinkedList<String> stringArraySort = fileReadArg.sortAL(stringArray);

        Supplier<Operation> userFactory = ()->{

            Scanner in = new Scanner(System.in);
            System.out.println("Select operation: frequency, length or duplicates");
            String name = in.nextLine();
            return new Operation(name);
        };

        Operation op1 = userFactory.get();

        switch (op1.getOperator()) {
            case "frequency":
                System.out.println();
                Printable prints = s -> System.out.println(s);
                prints.print("Frequency");
                Map<String, Integer> twoMostRepetitiveWords = operation1.frequency(stringArraySort);
                Map<String, Integer> sortedMapDesc = sortByComparator(twoMostRepetitiveWords, DESC);
                Printable printer = s->System.out.println(s);
                printer.print("Sorted Map!");
                printMap(sortedMapDesc);
                break;
            case "length":
                System.out.println();
                Printable printable = s -> System.out.println(s);
                printable.print("Length");
                operation1.lengthWord(stringArray);
                break;
            case "duplicates":
                System.out.println();
                Printable printables = s -> System.out.println(s);
                printables.print("Duplicate");
                LinkedList<String> threeWordsThatHaveDuplicate = operation1.duplicates(stringArray);
                System.out.println(threeWordsThatHaveDuplicate);
                break;
            default:
                System.out.println();
                Printable pr = s -> System.out.println(s);
                pr.print("Нет такой операции");
                break;
        }
    }
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, (o1, o2) -> {
            if (order) {
                return o1.getValue().compareTo(o2.getValue());
            } else {
                return o2.getValue().compareTo(o1.getValue());

            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    /**
     * Print map.
     *
     * @param map the map
     */
    public static void printMap(Map<String, Integer> map)
    {

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " -> "+ entry.getValue());
        }
    }
}
