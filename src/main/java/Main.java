public class Main {
    public static void main(String[] args) {
        Cat vasyaCat = new Cat("Vasya", 150);
        Dog bobikDog = new Dog("Bobik", 200, 150);
        bobikDog.run(100);
        bobikDog.run(240);
        bobikDog.swim(130);
        bobikDog.swim(160);

        vasyaCat.run(130);
        vasyaCat.run(170);
        vasyaCat.swim(300);
        System.out.println(Animal.getCountAnimalCreated());
    }
}
