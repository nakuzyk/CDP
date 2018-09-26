package com.epam.anastasiia_kuzyk.java.lesson1.task1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class DimensionalArray {

    public static void main (String args[]){

        int[] mas = GetArrayFromInput(20,-10,10);
        PrintArray(mas);
        SwapItems(mas);
        PrintArray(mas);

        }

    static int[] GetArrayFromInput(int x, int min, int max)
    {
        int[] arr = new int[x];
        int range = (max - min) + 1;

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random() * range) + min;

        }
        return arr;
    }

    static void SwapItems (int[] arr)
    {
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int indexOfMaximum = 0;
        int indexOfMinimum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0 && arr[i] > maximum) {
                maximum = arr[i];
                indexOfMaximum = i;
            }

            if(arr[i] > 0 && arr[i] < minimum) {
                minimum = arr[i];
                indexOfMinimum = i;
            }
        }
        int temp = arr[indexOfMaximum];
        arr[indexOfMaximum] = arr[indexOfMinimum];
        arr[indexOfMinimum] = temp;
    }

    static void PrintArray(int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

