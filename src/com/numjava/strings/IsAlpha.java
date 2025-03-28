package com.numjava.strings;

public class IsAlpha extends StringOperation {
    public boolean isAlpha(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = isAlpha(array[i]);
        }
        return result;
    }
    @Override
    public String getOperationName() {
        return "Alphabetic Check";
    }
}
