import com.numjava.matlib.Matrix;
import com.numjava.NDArray.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] array1Data = {1, 2, 3};
        double[] array2Data = {4, 5, 6};

        NDArray array1 = new NDArray(array1Data);
        NDArray array2 = new NDArray(array2Data);

        NDArray result = array1.add(array2);

        System.out.println("Array 1: " + array1);
        System.out.println("Array 2: " + array2);
        System.out.println("Result of addition: " + result);

        // Create an NDArray
        NDArray array = new NDArray(new double[]{1.0, 2.0, 3.0, 4.0, 5.0});

        // Display original NDArray
        System.out.println("Original NDArray:");
        System.out.println(array);

        // Round the NDArray (1 decimal place)
        NDArray roundedArray = Round.round(array, 1);
        System.out.println("\nRounded NDArray (1 decimal place):");
        System.out.println(roundedArray);

        // Reshape the NDArray (5x1)
        NDArray reshapedArray = Reshape.reshape(array, new int[]{5, 1}, "C", null);
        System.out.println("\nReshaped NDArray (5x1):");
        System.out.println(reshapedArray);

        // Check if any element in the original array is non-zero
        boolean anyNonZero = Any.any(array);
        System.out.println("\nAny non-zero in original array: " + anyNonZero);

        // Check if any element is greater than 3
        boolean anyGreaterThanThree = Any.anyCondition(array, value -> value > 3);
        System.out.println("Any element greater than 3: " + anyGreaterThanThree);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter: ");
        String input = s.nextLine();
        int[][] matrix = Matrix.matrix(input);

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        boolean allNonZero = Matrix.all(matrix);
        int[] maxIndex = Matrix.argmax(matrix);
        int[] minIndex = Matrix.argmin(matrix);

        System.out.println("All elements non-zero: " + allNonZero);
        System.out.println("Index of maximum element: (" + maxIndex[0] + ", " + maxIndex[1] + ")");
        System.out.println("Index of minimum element: (" + minIndex[0] + ", " + minIndex[1] + ")");

        // Test All class
        NDArray array3 = new NDArray(new double[]{1, 2, 3, 0});
        System.out.println("All elements are non-zero: " + All.all(array3));

        // Test IsFinite class
        NDArray array4 = new NDArray(new double[]{1, Double.NaN, 3, Double.POSITIVE_INFINITY});
        boolean[] isFiniteResults = IsFinite.isfinite(array4);
        System.out.print("Is finite results: ");
        for (boolean result1 : isFiniteResults) {
            System.out.print(result1 + " ");
        }
        System.out.println();

        // Test Transpose class
        NDArray array5 = new NDArray(new double[]{1, 2, 3, 4}, new int[]{2, 2});
        NDArray transposedArray = Transpose.transpose(array5);
        System.out.println("Transposed array: " + transposedArray);

        // Test ItemSize class
        System.out.println("Item size of array elements: " + ItemSize.itemsize(array1) + " bytes");

    }
}
