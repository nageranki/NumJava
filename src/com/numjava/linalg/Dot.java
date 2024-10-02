package com.numjava.linalg;

public class Dot {
        public static double dot (double[] array1, double[] array2) {
            if (array1.length == 0|| array2.length == 0 ){
                return 0 ;
            }
            // Hi this is a test comment.
            if (array1.length != array2.length) {
                throw new IllegalArgumentException("Arrays must be of same length ");
            }
            double result = 0 ;
            for (int i = 0; i < array1.length; i++) {
                result += array1[i]*array2[i];

            }
            return result;
        }

        public static int dot (int[] array1, int[] array2) {
            if (array1.length == 0|| array2.length == 0 ){
                return 0 ;
        }
            if (array1.length != array2.length) {
                throw new IllegalArgumentException("Arrays must be of same length ");
        }
            int result = 0 ;
            for (int i = 0; i < array1.length; i++) {
                result += array1[i]*array2[i];

        }
            return result;

    }
    public static float dot (float[] array1, float[] array2) {
        if (array1.length == 0|| array2.length == 0 ){
            return 0 ;
        }
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of same length ");
        }
        float result = 0 ;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i]*array2[i];

        }
        return result;
    }
    public static int[][] dot (int[][] array1 , int[][] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return new int[0][];
        }
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of the same outer length");
        }

        int rows = array1.length;
        int cols = array2[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                throw new IllegalArgumentException("Arrays must have the same inner lengths");
            }
            for (int j = 0; j < array1[i].length; j++) {
                result[i][j] += array1[i][j] * array2[i][j];
            }
        }
        return result;
    }



    public static float dot (float[][] array1 , float[][] array2){
            if (array1.length == 0 || array2.length == 0) {
                return 0;
            }
            if (array1.length != array2.length) {
                throw new IllegalArgumentException("Arrays must be of the same outer length");
            }

            float result = 0;
            for (int i = 0; i < array1.length; i++) {
                if (array1[i].length != array2[i].length) {
                    throw new IllegalArgumentException("Arrays must have the same inner lengths");
                }
                for (int j = 0; j < array1[i].length; j++) {
                    result += array1[i][j] * array2[i][j];
                }
            }
            return result;
        }
    public static double dot (double[][] array1 , double[][] array2){
        if (array1.length == 0 || array2.length == 0) {
            return 0;
        }
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of the same outer length");
        }

        double  result = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                throw new IllegalArgumentException("Arrays must have the same inner lengths");
            }
            for (int j = 0; j < array1[i].length; j++) {
                result += array1[i][j] * array2[i][j];
            }
        }
        return result;

    }



}


