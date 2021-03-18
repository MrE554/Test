import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "a", "a1", "a2" };
        System.out.println(toArrayList(array));

        String[] array1 = new String[] { "b1", "b4" };
        String[][] arrays = new String[][]{array, array1};
        System.out.println(Arrays.deepToString(arrays));
        System.out.println(Arrays.deepToString(change(arrays)));
    }

    private static Object[] change(Object[] array) {
        Object tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
        return array;
    }

    private static ArrayList<?> toArrayList(Object[] array) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object element : array) {
            arrayList.add(element);
        }

        return arrayList;
    }
}
