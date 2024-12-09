package com.numjava.strings;

import java.util.Arrays;

public class Add extends StringOperation {
    public String[] add(String[] array1, String[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Both arrays must have the same length.");
        }
        String[] result = new String[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] + array2[i];
        }
        return result;
    }
    public String[] add(String[] array, String str) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] + str;
        }
        return result;
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        return new boolean[0]; // Placeholder, not used here
    }
    @Override
    public String getOperationName() {
        return "Addition";
    }
}