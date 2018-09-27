package com.epam.anastasiia_kuzyk.java.lesson1.task2;

import java.util.Scanner;

public class WithString {
    public static void main(String[] args) {

        String[] strings = GetStringFromInput();
        LengthString(strings);

    }

    static String[] GetStringFromInput()
    {

        Scanner enter = new Scanner(System.in);
        Scanner strinner = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int n = enter.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < str.length; i++)
        {
            System.out.println("Введите строку: ");
            str[i]= strinner.nextLine();
        }
        return str;
    }

    static void LengthString(String[] strings) {

        int shorterStr = strings[0].length();
        String messShort = strings[0];
        int longerStr = strings[0].length();
        String messLong = strings[0];

        for (int i = 0; i < strings.length; i++)
        {
            if(strings[i].length() > longerStr) {
                longerStr = strings[i].length();
                messLong = strings[i];
            }
            if(strings[i].length() < shorterStr) {
                shorterStr = strings[i].length();
                messShort = strings[i];
            }
        }
        System.out.println(messShort);
        System.out.println(shorterStr);
        System.out.println(messLong);
        System.out.println(longerStr);
    }

}
