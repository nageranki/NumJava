package com.numjava.strings;

public class SwapCase extends StringOperation {
    private final SwapCaseHelper helper = new SwapCaseHelper();
    // Method to swap case for a single string
    private String swapCase(String str) {
        return helper.swapCaseLogic(str);
    }
    // Overriding applyOperation to process an array
    @Override
    public String[] applyOperation(String[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = swapCase(array[i]);
        }
        return result;
    }
    @Override
    public String getOperationName() {
        return "Swap Case";
    }
}
// Helper class for swap case logic
class SwapCaseHelper {
    public String swapCaseLogic(String str) {
        StringBuilder swapped = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                swapped.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                swapped.append(Character.toUpperCase(ch));
            } else {
                swapped.append(ch);
            }
        }
        return swapped.toString();
    }
}
