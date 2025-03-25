package com.numjava.NDArray;

public class Flatten {
    public static <T extends Number> GenericNDArray<T> flatten(GenericNDArray<T> array, String order) {
        T[] data = array.getData();
        int[] shape = array.getShape();
        T[] flattenedData = data.clone();

        if (order.equals("F")) { // Column-major order
            if (shape.length != 2) {
                throw new UnsupportedOperationException("Column-major order flattening is only supported for 2D arrays.");
            }
            T[] tempData = data.clone();
            int rows = shape[0];
            int cols = shape[1];
            for (int col = 0; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    flattenedData[col * rows + row] = tempData[row * cols + col];
                }
            }
        } else if (order.equals("A") || order.equals("K")) {
            // Order 'A' and 'K' are treated like 'C' here since Java does not manage memory in the same way as NumPy
            return new GenericNDArray<>(flattenedData, new int[]{flattenedData.length});
        }
        // Default to row-major order ('C')
        return new GenericNDArray<>(flattenedData, new int[]{flattenedData.length});
    }

    public static void main(String[] args) {
        // Create a GenericNDArray of Integers
        Integer[] intData = {1, 2, 3, 4, 5, 6};
        GenericNDArray<Integer> intArray = new GenericNDArray<>(intData, new int[]{2, 3});
        System.out.println("Original Integer NDArray:");
        intArray.printNDArray();

        // Flatten NDArray in row-major order
        // Test Comment
        GenericNDArray<Integer> flattenedArrayC = flatten(intArray, "C");
        System.out.println("\nFlattened NDArray (row-major order):");
        flattenedArrayC.printNDArray();

        // Flatten NDArray in column-major order
        GenericNDArray<Integer> flattenedArrayF = flatten(intArray, "F");
        System.out.println("\nFlattened NDArray (column-major order):");
        flattenedArrayF.printNDArray();
    }
}
