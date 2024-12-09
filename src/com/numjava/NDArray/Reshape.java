package com.numjava.NDArray;

public class Reshape {
    // Reshape to a new shape
    public static NDArray reshape(NDArray array, int[] shape, String order, Boolean copy) {
        int totalElements = 1;
        int negativeOneCount = 0;
        int inferredDimension = -1;

        // Validate shape and calculate total elements, also handle -1 (inferred) dimension
        for (int dim : shape) {
            if (dim == 0) {
                throw new IllegalArgumentException("Shape dimensions cannot be zero.");
            } else if (dim < -1) {
                throw new IllegalArgumentException("Shape dimensions must be positive or -1 for inferred size.");
            } else if (dim == -1) {
                if (negativeOneCount > 0) {
                    throw new IllegalArgumentException("Only one dimension can be -1 (inferred).");
                }
                negativeOneCount++;
            } else {
                totalElements *= dim;
            }
        }

        if (negativeOneCount == 1) {
            int arraySize = array.getSize();
            if (arraySize % totalElements != 0) {
                throw new IllegalArgumentException("The size of the array is not divisible by the inferred dimension.");
            }
            inferredDimension = arraySize / totalElements;
            for (int i = 0; i < shape.length; i++) {
                if (shape[i] == -1) {
                    shape[i] = inferredDimension;
                }
            }
        }

        // Recalculate total elements after determining inferred dimension
        totalElements = 1;
        for (int dim : shape) {
            totalElements *= dim;
        }

        if (totalElements != array.getSize()) {
            throw new IllegalArgumentException("New shape is incompatible with the data size.");
        }

        // Create a new NDArray with the reshaped data
        double[] reshapedData = new double[array.getSize()];

        // Copy data according to the specified order
        if ("F".equals(order)) {
            // Fortran-like order copying (column-major order)
            int[] originalShape = array.getShape();
            int[] originalStrides = calculateStridesFortran(originalShape);
            int[] newStrides = calculateStridesFortran(shape);
            for (int i = 0; i < array.getSize(); i++) {
                int[] originalIndices = calculateIndices(i, originalStrides, originalShape);
                int newIndex = calculateFlatIndex(originalIndices, newStrides);
                reshapedData[newIndex] = array.get(i);
            }
        } else {
            // Default to C-like order copying (row-major order)
            for (int i = 0; i < array.getSize(); i++) {
                reshapedData[i] = array.get(i);
            }
        }

        return new NDArray(reshapedData, shape); // Return new NDArray with reshaped data
    }

    // Overloaded method for backwards compatibility (only shape parameter)
    public static NDArray reshape(NDArray array, int[] shape) {
        return reshape(array, shape, "C", null); // Default to C-like order and no copy
    }

    private static int[] calculateStridesFortran(int[] shape) {
        int[] strides = new int[shape.length];
        int stride = 1;
        for (int i = 0; i < shape.length; i++) {
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
        int elementsInLastDim = shape[shape.length - 1];
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            if ((i + 1) % elementsInLastDim == 0) {
                System.out.println();
            }
        }
    }
}

