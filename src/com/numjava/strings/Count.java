package com.numjava.strings;

public class Count extends StringOperation {
    //Counts occurrences of a substring in each string of the array
    public int[] countOccurrences(String[] array, String substring) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = countSubstring(array[i], substring);
        }
        return result;
    }
    //Method to count occurrences of a substring in a single string
    public int countSubstring(String str, String substring) {
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Substring must not be null or empty.");
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        return new boolean[0]; // Placeholder, not used here
    }
    @Override
    public String getOperationName() {
        return "Count";
    }
}
