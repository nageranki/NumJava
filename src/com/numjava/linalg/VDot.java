package com.numjava.linalg;

import java.util.Vector;
import java.util.Objects;


public class VDot {

    public static void check(Vector<?> vec1, Vector<?> vec2) {
        Objects.requireNonNull(vec1, "First vector is null");
        Objects.requireNonNull(vec2, "Second vector is null");
        if (vec1.size() != vec2.size()) {
            throw new IllegalArgumentException("Vectors must be of the same length");
        }
    }


    public static <T extends Number> double dot(Vector<T> vec1, Vector<T> vec2) {
        check(vec1, vec2);

        double ans = 0.0;

        for (int i = 0; i < vec1.size(); i++) {
            T num1 = vec1.get(i);
            T num2 = vec2.get(i);
            Objects.requireNonNull(num1, "Element at index " + i + " in first vector is null");
            Objects.requireNonNull(num2, "Element at index " + i + " in second vector is null");

            ans += num1.doubleValue() * num2.doubleValue();
        }

        return ans;
    }
}
