import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{0, 3, 4, 5};
        System.out.println(search(8, array));
        System.out.println(search(3, array));
        String string = "this timeline will be reversed";
        System.out.println(reverse(string));

        int[] array1 = new int[]{7, 124, 23, 14, 54};
        System.out.println(maximum(array1));

        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(average(arrayList));
//        List<String> stringList = new ArrayList<String>();
//        stringList.add("hello");
//        stringList.add("paaark");
//        stringList.add("war");
//        stringList.add("afara");
//        System.out.println(search(stringList));
    }

    public static int search(Integer n, Integer[] list) {
        return Arrays.stream(list).filter(x -> x.equals(n))
                .findAny()
                .orElse(-1);
    }

//    public static List<String> search(List<String> list)  {
//        List<String> array = new ArrayList<String>();
//        for (String string : list) {
//            int a = (int) Stream.of(string.toCharArray()).filter(x -> {
//                System.out.println(x);
//                return "a".equals(x);
//            }).count();
//            if (a >= 3) {
//                array.add(string);
//            }
//        }
//        return array;
//    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static Integer maximum(int[] list) {
        return Arrays.stream(list).max().getAsInt();
    }

    public static Double average(List<Integer> list) {
        return  list.stream().reduce((x, y) -> x + y).get().doubleValue() / (long) list.size();
    }
}
