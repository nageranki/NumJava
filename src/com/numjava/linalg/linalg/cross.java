package com.numjava.linalg.linalg;

import java.util.Arrays;


public class cross {
    public static <T extends Number> Double[] crossProduct(T[] a, T[] b) {
        if (a.length != 3 || b.length != 3) {
            throw new IllegalArgumentException("Both vectors must have exactly three components.");
        }
        double ax = a[0].doubleValue();
        double ay = a[1].doubleValue();
        double az = a[2].doubleValue();
        double bx = b[0].doubleValue();
        double by = b[1].doubleValue();
        double bz = b[2].doubleValue();

        double cx = ay * bz - az * by;
        double cy = az * bx - ax * bz;
        double cz = ax * by - ay * bx;

        return new Double[]{cx, cy, cz};
    }
}
