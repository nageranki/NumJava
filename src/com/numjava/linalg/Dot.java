package com.numjava.linalg;

public class Dot {
    public static <T extends Number> double dot(T[] array1, T[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return 0;
        }

        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of the same length");
        }

        double result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i].doubleValue() * array2[i].doubleValue();
        }
        return result;
    }




    public static <T extends Number> double[][] dot(T[][] array1, T[][] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return new double[0][];
        }

        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must have the same number of rows");
        }

        int rows = array1.length;
        int cols = array1[0].length;

        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (array1[i].length != array2[i].length) {
                throw new IllegalArgumentException("Arrays must have the same number of columns in each row");
            }
            for (int j = 0; j < cols; j++) {
                result[i][j] = array1[i][j].doubleValue() * array2[i][j].doubleValue();
            }
        }

        return result;
    }


    public static void print2DArray(double[][] array) {
        for (double[] row : array) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }





}

