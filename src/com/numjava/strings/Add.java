package com.numjava.strings;

import java.util.Arrays;

public class Add{
    public static String[] add(String[] arr1, String[] arr2){
        if(arr1.length != arr2.length){
            throw new IllegalArgumentException("Both arrays must have same length.");
        }
        String[] result = new String[arr1.length];
        for(int i=0; i<arr1.length; i++){
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }
    public static String[] add(String[] arr, String str){
        String[] result = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = arr[i] + str;
        }
        return result;
    }
    public static void printArray(String[] array){
        System.out.println(Arrays.toString(array));
    }
}