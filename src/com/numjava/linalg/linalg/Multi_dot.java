package com.numjava.linalg.linalg;

public class Multi_dot {
    public static int[][] multi_dot(int[][] array1 , int[][] array2){
        int rows = array1.length;
        int cols = array2[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < array1[0].length; k++) {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }
    public static double[][] multi_dot(double[][] array1 , double[][] array2){
        int rows = array1.length;
        int cols = array2[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < array1[0].length; k++) {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
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
