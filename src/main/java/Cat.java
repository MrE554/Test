public class Cat extends Animal {
    private final String name;
    private final int maxDistanceRun;

    public Cat(String name, int maxDistanceRun) {
        countAnimalCreated++;
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
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
        System.out.println(name + " не умеет плавать!");
    }
}
