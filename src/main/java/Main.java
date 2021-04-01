public class Main {
    private static String a = "A";

    public static void main(String[] args) {
        Object lock = new Object();
        class MyClass implements Runnable {
            private String word;
            private String nextWord;

            public MyClass(String word, String nextWord) {
                this.word = word;
                this.nextWord = nextWord;
            }

            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (lock) {
                        try {
                            while (!a.equals(word))
                                lock.wait();
                            System.out.println(word);
                            a = nextWord;
                            Thread.sleep(1);
                            lock.notifyAll();
                        } catch (Exception e) {

                        }
                    }
                }
            }
        }

        new Thread(new MyClass("A", "B")).start();
        new Thread(new MyClass("B", "C")).start();
        new Thread(new MyClass("C", "A")).start();

    }
}
