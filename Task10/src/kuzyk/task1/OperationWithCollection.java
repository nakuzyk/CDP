package kuzyk.task1;

import java.util.*;

/**
 * The type Operation with collection.
 */
public class OperationWithCollection {
    /**
     * Frequency map.
     *
     * @param arls the arls
     * @return the map
     */
    public Map<String, Integer> frequency(LinkedList<String> arls) {
        Set<Integer> numberOfMatches = new HashSet<>();
        List<Integer> listOfStringLengths = new ArrayList<>();
        Map<String, Integer> wordAndNumberOfRepetitions = new HashMap<>();
        Map<String, Integer> twoMostRepetitiveWords = new LinkedHashMap<>();

        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < arls.size(); i += counter2) {
            counter = 1;
            String currentWord = arls.get(i);

            for (int j = i + 1; j < arls.size(); j++) {

                if (currentWord.equals(arls.get(j))) {
                    counter += 1;
                }
            }
            numberOfMatches.add(counter);
            wordAndNumberOfRepetitions.put(arls.get(i), counter);
            counter2 = counter;
        }
        listOfStringLengths.addAll(numberOfMatches);

        Collections.sort(listOfStringLengths);

        for (int i = listOfStringLengths.size() - 1; (i < listOfStringLengths.size()) && (i > listOfStringLengths.size() - 3); i--) {
            for (Map.Entry<String,Integer> entry : wordAndNumberOfRepetitions.entrySet()) {
                if (entry.getValue() == listOfStringLengths.get(i)) {
                    twoMostRepetitiveWords.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return twoMostRepetitiveWords;
    }

    /**
     * Length word.
     *
     * @param arls the arls
     */
    public void lengthWord(LinkedList<String> arls) {
        LinkedList<Integer> listOflength = new LinkedList<>();
        HashMap<String, Integer> threeLongestWords = new HashMap<>();
        Set<Integer> lengthOfWord = new HashSet<>();

        for (int i = 0; i < arls.size(); i++) {
            lengthOfWord.add(arls.get(i).length());
        }
        listOflength.addAll(lengthOfWord);
        Collections.sort(listOflength);
        int max = listOflength.getLast();


        for (int i = listOflength.size() - 1; i >= listOflength.size()-3; i--) {
            for (int j = arls.size()-1; j >= 0; j--) {
                if (listOflength.get(i) == arls.get(j).length()) {

                    threeLongestWords.put(arls.get(j),arls.get(j).length());
                }
            }
        }
        while( max >= 0){
            for (String key : threeLongestWords.keySet()){
                if(threeLongestWords.get(key) == max){
                    System.out.println(key + " -> " + threeLongestWords.get(key));
                }
            }
            max--;
        }
    }

    /**
     * Duplicates linked list.
     *
     * @param arls the arls
     * @return the linked list
     */
    public LinkedList<String> duplicates(LinkedList<String> arls) {
        ArrayList<Integer> numberOfRepetitionsOfEachWord = new ArrayList<>();
        ArrayList<String> repetitionsOfMoreThanOne = new ArrayList<>();
        LinkedList<String> threeWordsThatHaveDuplicate = new LinkedList<>();
        HashMap<String, Integer> wordAndItsNumberOfRepetitions = new HashMap<>();
        Set<String> hs = new HashSet<>();
        hs.addAll(arls);
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < arls.size(); i += count2) {
            count = 1;
            String currentWord = arls.get(i);
            for (int j = i + 1; j < arls.size(); j++) {

                if (currentWord.equals(arls.get(j))) {
                    count += 1;
                }
            }
            numberOfRepetitionsOfEachWord.add(count);
            wordAndItsNumberOfRepetitions.put(arls.get(i), count);
            count2 = count;
        }
        for (HashMap.Entry<String, Integer> entry : wordAndItsNumberOfRepetitions.entrySet()) {
            if (entry.getValue() > 1) {
                repetitionsOfMoreThanOne.add(entry.getKey());
            }
        }
        for (int i = 2; i >= 0; i--) {

            threeWordsThatHaveDuplicate.add(repetitionsOfMoreThanOne.get(i).toUpperCase());
        }
        return threeWordsThatHaveDuplicate;
    }
}
