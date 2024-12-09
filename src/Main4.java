import java.util.Arrays;
import com.numjava.strings.*;

public class Main4 {
    public static void main(String[] args) {
        Partition partitionOperation = new Partition();
        String[] inputArray = {"apple-pie", "chocolate-cake", "vanilla-icecream", "fruit"};
        String[][] result = partitionOperation.applyOperation(inputArray, "-");
        System.out.println("Partitioned Array:");
        for (String[] parts : result) {
            System.out.println(Arrays.toString(parts));
        }
    }
}
