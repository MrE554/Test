import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{0, 3, 4, 5};
        System.out.println(search(8, array));
        System.out.println(search(3, array));
        String string = "this timeline will be reversed";
        System.out.println(reverse(string));

        Integer[] array1 = new Integer[]{7, 124, 23, 14, 54};
        System.out.println(maximum(array1));

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(average(arrayList));
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("paaark");
        stringList.add("war");
        stringList.add("afara");
        System.out.println(search(stringList));
    }

    public static int search(Integer n, Integer[] list) {
        return Arrays.stream(list).filter(x -> x.equals(n))
                .findAny()
                .orElse(-1);
    }

    public static List<String> search(List<String> list)  {
        List<String> array = new ArrayList<String>();

        list.stream().forEach(x -> {
            int max = 0;
            // был ещё вариант сделать
            // int max = (int) Stream.of(x.toCharArray()).filter(y -> y == 'a').count()
            // но y не был типом char
            // почему? я не знаю
            for (char letter : x.toCharArray()) {
                if (letter == 'a') {
                    max++;
                }
            }
            if (max >= 3) {
                array.add(x);
            }
        });
        return array;
    }

    public static String reverse(String s) {
        return s.chars()
                .mapToObj(x -> (char) x)
                .reduce("", (y,f) -> f + y, (y1, f1) -> f1 + y1);
    }

    public static Integer maximum(Integer[] list) {
        return Arrays.stream(list).mapToInt(v -> v)
                .max()
                .getAsInt();
    }

    public static Double average(List<Integer> list) {
        return  list.stream().reduce((x, y) -> x + y).get().doubleValue() / list.size();
    }
}
