package com.numjava.strings;

public class IsDecimal extends StringOperation {
    public boolean isDecimal(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean[] applyOperation(String[] array) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = isDecimal(array[i]);
        }
        return result;
    }
    @Override
    public String getOperationName() {
        return "Decimal Check";
    }
}

