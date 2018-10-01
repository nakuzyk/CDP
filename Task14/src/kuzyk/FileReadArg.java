package kuzyk;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * The type File read arg.
 */
public class FileReadArg {
    /**
     * File reader string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String fileReader() throws IOException {
        String readsLine = "";
        Files.lines(Paths.get("src//Task1File.txt"));
        try (FileInputStream fileInputStream = new FileInputStream("src//Task1File.txt")) {
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                readsLine += (char) i;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return readsLine;
    }

    /**
     * Add to collection linked list.
     *
     * @param stringAfterReading the string after reading
     * @return the linked list
     */
    public LinkedList<String> addToCollection(String stringAfterReading) {
        int i = 0;
        LinkedList<String> inPutStringList = new LinkedList<String>();


        String[] words = stringAfterReading.split(",|\\s|:|\\.|\\?|;");
        for (String word : words) {
            if (word.equals("")) {
            } else {
                inPutStringList.add(word);
            }
        }

        return inPutStringList;

    }

    /**
     * Sort al linked list.
     *
     * @param inPutStringList the in put string list
     * @return the linked list
     */
    public LinkedList<String> sortAL(LinkedList<String> inPutStringList) {
        Collections.sort(inPutStringList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString()) * (-1);
            }
        });
        return inPutStringList;
    }


}
