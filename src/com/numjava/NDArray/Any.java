package com.numjava.NDArray;

public class Any {
    // Check if any element in the array is non-zero or NaN
    public static boolean any(NDArray array) {
        return any(array, null, false);
    }

    // Check if any element along a specific axis is non-zero
    public static boolean any(NDArray array, Integer axis, boolean keepdims) {
        // Handle axis
        if (axis != null && axis != 0) {
            throw new IllegalArgumentException("For now, only axis=0 (row-wise) is supported.");
        }

        int size = array.getSize();
        if (size == 0) {
            return false; // Return false for empty arrays
        }

        boolean result = false;

        for (int i = 0; i < size; i++) {
            double value = array.get(i); // Use get method to access elements
            if (value != 0.0 || Double.isNaN(value)) {
                result = true; // If any value is non-zero or NaN, return true
                break;
            }
        }

        // Optionally handle keepdims
        if (keepdims) {
            // This is a placeholder; actual implementation may vary based on requirements
            // You might want to return a reshaped NDArray instead
        }

        return result; // Return the final result
    }

    // Check if any element satisfies a condition
    public static boolean anyCondition(NDArray array, Condition condition) {
        for (int i = 0; i < array.getSize(); i++) {
            double value = array.get(i); // Use get method to access elements
            if (condition.test(value)) {
                return true; // Return true if any element satisfies the condition
            }
        }
        return false; // Return false if no elements satisfy the condition
    }

    // Define a functional interface to handle conditions
    @FunctionalInterface
    public interface Condition {
        boolean test(double value); // Method to test a condition on a value
    }
}
