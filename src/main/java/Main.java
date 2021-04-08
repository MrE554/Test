import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public int[] getFromArrayEverythingAfterFour(int[] array) {
        if (Arrays.stream(array).noneMatch(x -> x == 4)) {
            throw new RuntimeException();
        }
        List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
        return Arrays.copyOfRange(array, arr.indexOf(4) + 1, array.length);
    }

    public boolean checkArrayHaveOneAndFour(int[] array) {
        return Arrays.stream(array).anyMatch(x -> x == 4) && Arrays.stream(array).anyMatch(x -> x == 1);
    }
}
