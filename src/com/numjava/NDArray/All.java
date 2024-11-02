package com.numjava.NDArray;

// NumJava equivalent of numpy.all
public class All {
    public static boolean all(NDArray array) {
        return all(array, null, false, null);
    }

    public static boolean all(NDArray array, Integer axis, boolean keepdims, boolean[] where) {
        int size = array.getSize();
        boolean result = true;

        for (int i = 0; i < size; i++) {
            double value = array.get(i);
            if (where == null || where[i]) {
                if (value == 0.0 || Double.isNaN(value)) {
                    result = false;
                    break;
                }
            }
        }

        if (keepdims) {
            // Placeholder: handle reshaping dimensions as needed for reduced axes
        }

        return result;
    }
}