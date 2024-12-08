import com.numjava.NDArray.*;

import static com.numjava.NDArray.All.all;

public class Main{
    public static void main(String[] args) {
        // Create a single NDArray instance

        double[] data = {1.56,2.79, 3.84,4.13,5.26,6.0};
        NDArray array = new NDArray(data);

        // Display the original NDArray
        System.out.println("Original NDArray: ");
        NDArray.printNDArray(array);

        // Round the NDArray (1 decimal place)
        NDArray roundedArray = Round.round(array, 1);
        System.out.println("\nRounded NDArray (1 decimal place): ");
        NDArray.printNDArray(roundedArray);

        // Reshape the NDArray (3x2)
        int[] newShape = {3,2};
        NDArray reshapedArray = Reshape.reshape(array, newShape);
        System.out.println("\nReshaped NDArray (3x2): ");
        NDArray.printNDArray(reshapedArray);

        // Check if any element in the array is non-zero
        boolean anyNonZero = Any.any(array);
        System.out.println("\nAny non-zero in original array: " + anyNonZero);

        // Check if any element is greater than 3
        boolean anyGreaterThanThree = Any.anyCondition(array, value -> value > 3);
        System.out.println("Any element greater than 3: " + anyGreaterThanThree);

        // Check if all elements are non-zero
        System.out.println("All elements are non-zero: " + all(array));

        // Test IsFinite class
        NDArray arrayWithInf = new NDArray(new double[]{1, Double.NaN, 3, Double.POSITIVE_INFINITY});
        boolean[] isFiniteResults = IsFinite.isfinite((arrayWithInf));
        System.out.println("Is finite results: ");
        for (boolean result : isFiniteResults){
            System.out.println(result + " ");
        }
        System.out.println();

        // Testing Transpose class
        NDArray transposedArray = Transpose.transpose(reshapedArray);
        System.out.println("\nTransposed NDArray: ");
        Transpose.printNDArray(transposedArray);

        // Test ItemSize Class
        System.out.println("\nItem size of array elements: " + ItemSize.itemsize(array) + " bytes");
    }
}