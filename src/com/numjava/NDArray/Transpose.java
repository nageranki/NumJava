package com.numjava.NDArray;

// NumJava equivalent of numpy.ndarray.transpose
public class Transpose {
    public static NDArray transpose(NDArray array) {
        return transpose(array, null);
    }

    public static NDArray transpose(NDArray array, int[] axes) {
        int[] originalShape = array.getShape();
        int numAxes = originalShape.length;

        if (axes == null) {
            axes = new int[numAxes];
            for (int i = 0; i < numAxes; i++) {
                axes[i] = numAxes - 1 - i;
            }
        }

        if (axes.length != numAxes) {
            throw new IllegalArgumentException("Axes length must match number of dimensions in NDArray.");
        }

        int[] newShape = new int[numAxes];
        for (int i = 0; i < numAxes; i++) {
            newShape[i] = originalShape[axes[i]];
        }

        double[] transposedData = new double[array.getSize()];

        // Placeholder: perform transposition operation
        // Need to implement logic for rearranging data based on axes order

        return new NDArray(transposedData, newShape);
    }
}


