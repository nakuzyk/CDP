package kuzyk.task1;

import java.util.*;

public class Main {
    public static boolean DESC = true;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        OperationWithCollection op = new OperationWithCollection();
        FileReadArg fr = new FileReadArg();
        fr.fileReader();
        LinkedList<String> ars = fr.addToCollection(fr.fileReader());

        LinkedList<String> arssort = fr.sortAL(ars);

        System.out.println("Select operation: frequency, length or duplicates");
        String operation = scanner.nextLine();

        switch (operation) {
            case "frequency":
                System.out.println("Frequency");
                Map<String, Integer> hm = op.frequency(arssort);
                Map<String, Integer> sortedMapDesc = sortByComparator(hm, DESC);
                printMap(sortedMapDesc);
                break;
            case "length":
                System.out.println("Length");
                op.lengthWord(ars);
                break;
            case "duplicates":
                System.out.println("Duplicate");
                LinkedList<String> ard = op.duplicates(ars);
                System.out.println(ard);
                break;
            default:
                System.out.println("Нет такой операции");
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

    public static void printMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " -> "+ entry.getValue());
        }
    }
}
