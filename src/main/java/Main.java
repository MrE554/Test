public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private final int a = 1;

    public static void main(String[] args) {
        float[] arr = new float[size];
        long startTime = System.currentTimeMillis();
        fillArray(arr);
        System.out.println(System.currentTimeMillis() - startTime);

        long startTime1 = System.currentTimeMillis();
        breakDown(arr);
        System.out.println(System.currentTimeMillis() - startTime1);
    }

    private static void fillArray(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void breakDown(float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        new Thread(() -> {
            for (int i = 0; i < h; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }}).start();
        new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }}).start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
