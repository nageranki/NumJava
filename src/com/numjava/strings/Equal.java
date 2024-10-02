package com.numjava.strings;

import java.util.Arrays;

public class Equal{
    public static boolean[] equal(String[] arr1, String[] arr2){
        if(arr1.length != arr2.length){
            throw new IllegalArgumentException("Both arrays must have the same length.");
        }
        boolean[] result = new boolean[arr1.length];
        for(int i=0; i<arr1.length; i++){
            result[i] = arr1[i].equals(arr2[i]);
        }
        return result;
    }
    public static void printArray(boolean[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
