package com.numjava.linalg.linalg;

public class Multi_dot {

    public static <T extends Number> double[][] multi_dot(T[][] array1, T[][] array2) {
        if (array1[0].length != array2.length) {
            throw new IllegalArgumentException("Number of columns in array1 must be equal to number of rows in array2 for multiplication.");
        }

        int rows = array1.length;
        int cols = array2[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < array1[0].length; k++) {
                    result[i][j] += array1[i][k].doubleValue() * array2[k][j].doubleValue();
                }
            }
        }
        return result;
    }

    public static void print2DArray(double[][] array) {
        for (double[] row : array) {
            for (double value : row) {
                System.out.printf("%.7f ", value);
            }
            System.out.println();
        }
    }
}