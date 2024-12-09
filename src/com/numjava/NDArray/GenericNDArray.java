package com.numjava.NDArray;

public class GenericNDArray<T extends Number> {
    private T[] data;
    private int[] shape;

    public GenericNDArray(T[] data) {
        this.data = data;
        this.shape = new int[]{data.length};
    }

    public GenericNDArray(T[] data, int[] shape) {
        this.data = data;
        this.shape = shape;
    }

    public int[] getShape() {
        return shape;
    }

    public T[] getData() {
        return data;
    }

    public void printNDArray() {
        int elementsInLastDim = shape[shape.length - 1];
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            if ((i + 1) % elementsInLastDim == 0) {
                System.out.println();
            }
        }
    }
}
