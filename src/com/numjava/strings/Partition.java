package com.numjava.strings;

public class Partition extends StringOperation {
    @Override
    public String[][] applyOperation(String[] array) {
        throw new UnsupportedOperationException("Partitioning requires a delimiter, use the overloaded method.");
    }

    // Method to partition strings in the array based on a delimiter
    public String[][] applyOperation(String[] array, String delimiter) {
        String[][] result = new String[array.length][3];
        for (int i = 0; i < array.length; i++) {
            result[i] = partitionString(array[i], delimiter);
        }
        return result;
    }

    private String[] partitionString(String str, String delimiter) {
        String[] parts = new String[3];
        int index = str.indexOf(delimiter);
        if (index == -1) {
            parts[0] = str;
            parts[1] = "";
            parts[2] = "";
        } else {
            parts[0] = str.substring(0, index);
            parts[1] = delimiter;
            parts[2] = str.substring(index + delimiter.length());
        }
        return parts;
    }

    @Override
    public String getOperationName() {
        return "Partition";
    }
}
