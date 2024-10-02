package com.numjava.NDArray;

public class Round {
    // Round elements to a specified number of decimal places
    public static NDArray round(NDArray array, int decimals) {
        if (decimals < 0) {
            throw new IllegalArgumentException("Decimals cannot be negative.");
        }

        int size = array.getSize(); // Get the size of the NDArray
        double[] roundedData = new double[size]; // Array to hold rounded values
        double factor = Math.pow(10, decimals); // Factor for rounding

        for (int i = 0; i < size; i++) {
            double value = array.get(i); // Use get method to access elements

            // Handle special cases for NaN and Infinite values
            if (Double.isNaN(value)) {
                roundedData[i] = Double.NaN; // Preserve NaN
            } else if (Double.isInfinite(value)) {
                roundedData[i] = value; // Preserve Infinity
            } else {
                // Round the value to the specified number of decimal places
                roundedData[i] = Math.round(value * factor) / factor;
            }
        }

        return new NDArray(roundedData); // Return new NDArray with rounded data
    }

    // Overloaded method to round to 0 decimal places by default
    public static NDArray round(NDArray array) {
        return round(array, 0); // Call the main round method with 0 decimals
    }
}
