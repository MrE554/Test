public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(120);
        Cat cat1 = new Cat(18);
        cat1.setPlate(plate);
        plate.setAmountOfFood(cat1.eat());
        System.out.println("Отсталось еды в тарелки " + plate.getAmountOfFood());

        System.out.println();

        Plate plate1 = new Plate(150);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat(30);
        cats[1] = new Cat(400);
        cats[2] = new Cat(20);
        cats[3] = new Cat(5);
        cats[4] = new Cat(90);

        plate1.addAmountOfFood(36);

        for ( Cat cat : cats) {
            cat.setPlate(plate1);
            plate1.setAmountOfFood(cat.eat());
            System.out.println("Кот голоден? " + cat.isHungry());
        }
        System.out.println("Отсталось еды в тарелки " + plate1.getAmountOfFood());
    }
}
