package com.numjava.NDArray;

// NumJava equivalent of numpy.ndarray.itemsize
public class ItemSize {
    public static int itemsize(NDArray array) {
        return Double.BYTES; // Since NDArray stores data as double, each element takes 8 bytes
    }
}
