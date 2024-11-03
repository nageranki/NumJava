import com.numjava.NDArray.*;

import static com.numjava.NDArray.All.all;
import static com.numjava.NDArray.Reshape.printNDArray;

public class Main3 {
    public static void main(String[] args) {
        double[] array1Data = {1, 2, 3};
        double[] array2Data = {4, 5, 6};

        NDArray array1 = new NDArray(array1Data);
        NDArray array2 = new NDArray(array2Data);

        NDArray result = array1.add(array2);

        System.out.println("Array 1: " + array1);
        System.out.println("Array 2: " + array2);
        System.out.println("Result of addition of Array1 & Array2: " + result);

        // Create an NDArray
        NDArray array = new NDArray(new double[]{1.56, 2.79, 3.84, 4.13, 5.26});

        // Display original NDArray
        System.out.println("Original NDArray:");
        System.out.println(array);

        // Round the NDArray (1 decimal place)
        NDArray roundedArray = Round.round(array, 1);
        System.out.println("\nRounded NDArray (1 decimal place):");
        System.out.println(roundedArray);

        // Reshape the NDArray (5x1)
        double[] data2 = {1, 2, 3, 4, 5, 6};
        int[] shape2 = {3, 2};
        NDArray array5 = new NDArray(data2, shape2);

        System.out.println("Reshaped NDArray:");
        printNDArray(array5);

        // Check if any element in the original array is non-zero
        boolean anyNonZero = Any.any(array);
        System.out.println("\nAny non-zero in original array: " + anyNonZero);

        // Check if any element is greater than 3
        boolean anyGreaterThanThree = Any.anyCondition(array, value -> value > 3);
        System.out.println("Any element greater than 3: " + anyGreaterThanThree);

        // Test All class
        double[] data = {1, 2, 3, 4, 5, 6};
        int[] shape = {2, 3};
        NDArray array3 = new NDArray(data, shape);
        System.out.println("All elements are non-zero: " + all(array3));

        double[] dataWithZero = {1, 2, 0, 4, 5, 6};
        NDArray arrayWithZero = new NDArray(dataWithZero, shape);
        System.out.println("All elements are non-zero: " + all(arrayWithZero));

        // Test IsFinite class
        NDArray array4 = new NDArray(new double[]{1, Double.NaN, 3, Double.POSITIVE_INFINITY});
        boolean[] isFiniteResults = IsFinite.isfinite(array4);
        System.out.print("Is finite results: ");
        for (boolean result1 : isFiniteResults) {
            System.out.print(result1 + " ");
        }
        System.out.println();

        // Test Transpose class
        double[] data1 = {1, 2, 3, 4, 5, 6};
        int[] shape1 = {2, 3};
        NDArray array6 = new NDArray(data1, shape1);

        System.out.println("Original NDArray:");
        Transpose.printNDArray(array6);

        NDArray transposedArray = Transpose.transpose(array6);

        System.out.println("\nTransposed NDArray:");
        Transpose.printNDArray(transposedArray);

        // Test ItemSize class
        System.out.println("Item size of array elements: " + ItemSize.itemsize(array1) + " bytes");
    }
}
