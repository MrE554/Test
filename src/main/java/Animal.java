public abstract class Animal {
    protected static int countAnimalCreated;

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCountAnimalCreated() {
        return countAnimalCreated;
    }
}
