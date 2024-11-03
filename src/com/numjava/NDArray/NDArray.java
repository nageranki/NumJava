package com.numjava.NDArray;

public class NDArray {
    private double[] data;
    private int[] shape; // Store the shape of the NDArray
    private int size;

    // Constructor for creating an array with a given size
    public NDArray(int size) {
        this.size = size;
        this.data = new double[size];
        this.shape = new int[]{size}; // Default shape
    }

    // Constructor for creating an array with initial values
    public NDArray(double[] initialValues) {
        this.size = initialValues.length;
        this.data = new double[size];
        System.arraycopy(initialValues, 0, this.data, 0, size);
        this.shape = new int[]{size}; // Shape based on initial values
    }

    // Constructor for creating an NDArray with data and shape
    public NDArray(double[] data, int[] shape) {
        this.data = data; // Directly assign the data
        this.shape = shape;
        this.size = data.length; // Size is determined by the length of the data
    }

    // Method to get the value at a specific index
    public double get(int index) {
        return data[index];
    }

    // Method to set the value at a specific index
    public void set(int index, double value) {
        data[index] = value;
    }

    // Method to get the size of the array
    public int getSize() {
        return size;
    }

    // Method to add two NDArray objects element-wise
    public NDArray add(NDArray other) {
        if (this.size != other.getSize()) {
            throw new IllegalArgumentException("Arrays must be of the same size.");
        }

        double[] resultData = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            resultData[i] = this.data[i] + other.get(i);
        }
        return new NDArray(resultData);
    }

    // Method to get the shape of the array
    public int[] getShape() {
        return shape;
    }

    // Method to set the shape of an array
    public void setShape(int[] shape) {
        this.shape = shape;
    }

    // Method to return the data of an array
    public double[] getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

