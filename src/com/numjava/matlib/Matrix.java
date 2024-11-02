package com.numjava.matlib;

import java.util.Scanner;

public class Matrix {
    private final int[][] data;

    // Constructor to initialize the matrix from a 2D array
    public Matrix(int[][] data) {
        this.data = data;
    }

    // Method to transpose the matrix
    public Matrix getT() {
        int rows = data.length;
        int cols = data[0].length;
        int[][] transposedData = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return new Matrix(transposedData);
    }

    // Method to get the Hermitian transpose (conjugate transpose)
    public Matrix getH() {
        return getT(); // For real matrices, Hermitian is the same as transpose
    }

    // Method to create an identity matrix of a given size
    public static Matrix getI(int size) {
        int[][] identityData = new int[size][size];
        for (int i = 0; i < size; i++) {
            identityData[i][i] = 1; // Set diagonal elements to 1
        }
        return new Matrix(identityData);
    }

    // Method to add two matrices
    public Matrix getA(Matrix other) {
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        int rows = this.data.length;
        int cols = this.data[0].length;
        int[][] sumData = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumData[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(sumData);
    }

    // Method to convert input string to matrix
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

    // Check if all elements are non-zero
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

    // Check if any element is non-zero
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

    // Get the index of the maximum element
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

    // Get the index of the minimum element
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

    // Print the matrix
    public void print() {
        for (int[] row : data) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter matrix (rows separated by ';'):");
        String input = s.nextLine();
        int[][] inputMatrix = matrix(input);
        Matrix mat = new Matrix(inputMatrix);

        System.out.println("Original Matrix:");
        mat.print();

        System.out.println("Transpose:");
        mat.getT().print();

        System.out.println("Hermitian Transpose:");
        mat.getH().print();

        // Create and print identity matrix
        int size = inputMatrix.length; // Assuming square identity matrix for simplicity
        System.out.println("Identity Matrix:");
        getI(size).print();

        // Add the original matrix to itself as an example
        System.out.println("Sum of Original Matrix with Itself:");
        Matrix sumMatrix = mat.getA(mat);
        sumMatrix.print();

        boolean allNonZero = all(inputMatrix);
        boolean anyNonZero = any(inputMatrix);
        int[] maxIndex = argmax(inputMatrix);
        int[] minIndex = argmin(inputMatrix);

        System.out.println("All elements non-zero: " + allNonZero);
        System.out.println("Any element non-zero: " + anyNonZero);
        System.out.println("Index of maximum element: (" + maxIndex[0] + ", " + maxIndex[1] + ")");
        System.out.println("Index of minimum element: (" + minIndex[0] + ", " + minIndex[1] + ")");
    }
}