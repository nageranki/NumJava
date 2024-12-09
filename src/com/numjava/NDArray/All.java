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
            if (where == null || (where.length > i && where[i])) {
                if (value == 0.0 || Double.isNaN(value)) {
                    result = false;
                    break;
                }
            }
        }

        if (keepdims && axis != null) {
            int[] originalShape = array.getShape();
            int[] newShape = new int[originalShape.length];
            System.arraycopy(originalShape, 0, newShape, 0, originalShape.length);
            newShape[axis] = 1;
            array.setShape(newShape);
        }

        return result;
    }
}