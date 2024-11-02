package com.numjava.strings;

public class Replace extends StringOperation {
    // Replace occurrences of a substring in each string of the array
    public String[] replaceSubstring(String[] array, String oldSubstring, String newSubstring) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = replace(array[i], oldSubstring, newSubstring);
        }
        return result;
    }
    // Method to replace occurrences of a substring in a single string
    public String replace(String str, String oldSubstring, String newSubstring) {
        if (oldSubstring == null || newSubstring == null) {
            throw new IllegalArgumentException("Substrings must not be null.");
        }
        return str.replace(oldSubstring, newSubstring);
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        return new boolean[0]; // Placeholder, not used here
    }
    @Override
    public String getOperationName() {
        return "Replace";
    }
}

