package kuzyk.task1;

import java.util.*;

public class OperationWithCollection {
    public Map<String, Integer> frequency(LinkedList<String> arls) {
        Set<Integer> hs = new HashSet<>();
        List<Integer> lc = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        Map<String, Integer> nhm = new LinkedHashMap<>();
//
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < arls.size(); i += counter2) {
            counter = 1;
            String w = arls.get(i);
            for (int j = i + 1; j < arls.size(); j++) {

                if (w.equals(arls.get(j))) {
                    counter += 1;
                }
            }
            hs.add(counter);
            hm.put(arls.get(i), counter);
            counter2 = counter;
        }
        lc.addAll(hs);

        Collections.sort(lc);

        for (int i = lc.size() - 1; (i < lc.size()) && (i > lc.size() - 3); i--) {
            for (Map.Entry<String,Integer> entry : hm.entrySet()) {
                if (entry.getValue() == lc.get(i)) {
                    nhm.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return nhm;
    }
    public void lengthWord(LinkedList<String> arls) {
        LinkedList<Integer> arlength = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < arls.size(); i++) {
            hs.add(arls.get(i).length());
        }
        arlength.addAll(hs);
        Collections.sort(arlength);
        int max = arlength.getLast();


        for (int i = arlength.size() - 1; i >= arlength.size()-3; i--) {
            for (int j = arls.size()-1; j >= 0; j--) {
                if (arlength.get(i) == arls.get(j).length()) {

                    hm.put(arls.get(j),arls.get(j).length());
                }
            }
        }
        while( max >= 0){
            for (String key : hm.keySet()){
                if(hm.get(key) == max){
                    System.out.println(key + " -> " + hm.get(key));
                }
            }
            max--;
        }
    }
    public LinkedList<String> duplicates(LinkedList<String> arls) {
        ArrayList<Integer> arrepeat = new ArrayList<>();
        ArrayList<String> arrduplicates = new ArrayList<>();
        LinkedList<String> narrduplicates = new LinkedList<>();
        HashMap<String, Integer> hmd = new HashMap<>();
        Set<String> hs = new HashSet<>();
        hs.addAll(arls);
        int countr = 0;
        int countr2 = 0;
        for (int i = 0; i < arls.size(); i += countr2) {
            countr = 1;
            String w = arls.get(i);
            for (int j = i + 1; j < arls.size(); j++) {

                if (w.equals(arls.get(j))) {
                    countr += 1;
                }
            }
            arrepeat.add(countr);
            hmd.put(arls.get(i), countr);
            countr2 = countr;
        }
        for (HashMap.Entry<String, Integer> entry : hmd.entrySet()) {
            if (entry.getValue() > 1) {
                arrduplicates.add(entry.getKey());
            }
        }
        for (int i = 2; i >= 0; i--) {

            narrduplicates.add(arrduplicates.get(i).toUpperCase());
        }
        return narrduplicates;
    }
}
