package com.numjava.strings;

public class Find extends StringOperation {
    // Find the first occurrence of a substring in each string of the array
    public int[] findSubstring(String[] array, String substring) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = find(array[i], substring);
        }
        return result;
    }
    // Method to find the first occurrence of a substring in a single string
    public int find(String str, String substring) {
        if (substring == null) {
            throw new IllegalArgumentException("Substring must not be null.");
        }
        return str.indexOf(substring);
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        return new boolean[0]; // Placeholder, not used here
    }
    @Override
    public String getOperationName() {
        return "Find";
    }
}

