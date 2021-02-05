public class Dog extends Animal {
    private final String name;
    private final int maxDistanceRun;
    private final int maxDistanceSwim;

    public Dog(String name, int maxDistanceRun, int maxDistanceSwim) {
        countAnimalCreated++;
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
    }

    @Override
    public void run(int distance) {
        if (distance > maxDistanceRun) {
            System.out.println(name + " не сможет пробежать " + distance +
                    ", он может только пробежать " + maxDistanceRun);
            return;
        }
        System.out.println(name + " пробежал " + distance + " метров ");
    }

    @Override
    public void swim(int distance) {
        if (distance > maxDistanceSwim) {
            System.out.println(name + " не сможет проплыть " + distance +
                    ", он может только проплыть " + maxDistanceSwim);
            return;
        }
        System.out.println(name + " проплыл " + distance + " метров");
    }
}
