package com.numjava.strings;

public class IsAlpha {
    public static boolean isalpha(String str){
        for(char ch : str.toCharArray()){
            if(!Character.isLetter(ch)){
                return false;
            }
        }
        return true;
    }
    public static boolean[] isalphaarray(String[] arr) {
        boolean[] result = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            result[i] = isalpha(arr[i]);
        }
        return result;
    }
}
