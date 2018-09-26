package kuzyk.task2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        ClassChar ch1 = new ClassChar("ewresdf");
        ClassChar ch2 = new ClassChar("asfgfgdf");
        ClassChar ch3 = new ClassChar("asfgfgdf");
        ClassChar ch4 = new ClassChar("dfffffffffsdf");
        Chair c1 = new Chair();
        Chair c2 = new Chair(60, "lovely rabbit", false);
        Table t1 = new Table();
        Table t2 = new Table(30, "good table", "fir");

        LinkedHashMap hmv = new LinkedHashMap();

        hmv.put(ch1,c1);
        hmv.put(ch2,c2);
        hmv.put(ch3,t1);
        hmv.put(ch4,t2);
        Iterator hmiterdf = hmv.keySet().iterator();
        ClassString str1 = new ClassString("str1");
        ClassString str2 = new ClassString("stgfdgfdgdfg");
        ClassString str3 = new ClassString("stfgdf");
        ClassString str4 = new ClassString("dfgdfgdfgdfbbg");
        while(hmiterdf.hasNext())

        {
            Object obj = hmiterdf.next();

            System.out.println(obj.hashCode());
            LinkedHashMap hasmap = new LinkedHashMap();
            hasmap.put(str1, c1);
            hasmap.put(str2, c2);
            hasmap.put(str3, t1);
            hasmap.put(str4, t2);
            Iterator hasmapit = hasmap.keySet().iterator();
            while (hasmapit.hasNext()) {
                Object obj2 = hasmapit.next();

                System.out.println(obj2.hashCode());
            }
        }
    }

}
