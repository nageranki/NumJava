package com.numjava.NDArray;

// NumJava equivalent of numpy.isfinite
public class IsFinite {
    public static boolean[] isfinite(NDArray array) {
        return isfinite(array, null);
    }

    public static boolean[] isfinite(NDArray array, boolean[] where) {
        int size = array.getSize();
        boolean[] result = new boolean[size];

        for (int i = 0; i < size; i++) {
            double value = array.get(i);
            result[i] = (where == null || where[i]) && !(Double.isNaN(value) || Double.isInfinite(value));
        }

        return result;
    }
}
