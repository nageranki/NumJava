package com.numjava.matlib;
import java.util.Scanner;
//testcheck
public class Matrix {
    public static int[][] matrix(String input) {
        String[] rows = input.split(";");
        int[][] matrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].trim().split("\\s+");
            matrix[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return matrix;
    }

    public static boolean all(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean any(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] argmax(int[][] matrix) {
        int maxVal = Integer.MIN_VALUE;
        int[] index = {-1, -1};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    public static int[] argmin(int[][] matrix) {
        int minVal = Integer.MAX_VALUE;
        int[] index = {-1, -1};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
}