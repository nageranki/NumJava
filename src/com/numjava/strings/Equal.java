package com.numjava.strings;

import java.util.Arrays;

public class Equal extends StringOperation {
    public boolean[] equal(String[] array1, String[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Both arrays must have the same length.");
        }
        boolean[] result = new boolean[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i].equals(array2[i]);
        }
        return result;
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        return new boolean[0]; // Placeholder, specific to this method
    }
    @Override
    public String getOperationName() {
        return "Equality Check";
    }
}

