package kuzyk.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FileReadArg {
    public String fileReader() {
        String str = "";
        try (FileInputStream fin = new FileInputStream("src//Task1File.txt")) {
            int i = -1;
            while ((i = fin.read()) != -1) {
                str += (char) i;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }

    public LinkedList<String> addToCollection(String stringAfterReading) {
        int i = 0;
        LinkedList<String> stringarray = new LinkedList<String>();

        String[] words = stringAfterReading.split(",|\\s|:|\\.|\\?|;");
        for (String word : words) {
            if (word.equals("")) {
            } else {
                stringarray.add(word);
            }
        }

        return stringarray;

    }

    public LinkedList<String> sortAL(LinkedList<String> stringarray) {
        Collections.sort(stringarray, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString()) * (-1);
            }
        });
        return stringarray;
    }


}
