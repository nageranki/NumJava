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
        int[] originalStrides = calculateStrides(originalShape);
        int[] newStrides = calculateStrides(newShape);

        // Perform transposition operation
        for (int i = 0; i < array.getSize(); i++) {
            int[] originalIndices = calculateIndices(i, originalStrides, originalShape);
            int[] newIndices = new int[numAxes];
            for (int j = 0; j < numAxes; j++) {
                newIndices[j] = originalIndices[axes[j]];
            }
            int newIndex = calculateFlatIndex(newIndices, newStrides);
            transposedData[newIndex] = array.getData()[i];
        }

        return new NDArray(transposedData, newShape);
    }

    private static int[] calculateStrides(int[] shape) {
        int[] strides = new int[shape.length];
        int stride = 1;
        for (int i = shape.length - 1; i >= 0; i--) {
            strides[i] = stride;
            stride *= shape[i];
        }
        return strides;
    }

    private static int[] calculateIndices(int flatIndex, int[] strides, int[] shape) {
        int[] indices = new int[shape.length];
        for (int i = 0; i < shape.length; i++) {
            indices[i] = (flatIndex / strides[i]) % shape[i];
        }
        return indices;
    }

    private static int calculateFlatIndex(int[] indices, int[] strides) {
        int flatIndex = 0;
        for (int i = 0; i < indices.length; i++) {
            flatIndex += indices[i] * strides[i];
        }
        return flatIndex;
    }

    public static void printNDArray(NDArray array) {
        int[] shape = array.getShape();
        double[] data = array.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            if ((i + 1) % shape[shape.length - 1] == 0) {
                System.out.println();

            }
        }
    }
}

