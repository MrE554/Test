public class Ex1 {
    public static void main(String[] args) {
        Box<Orange> boxOrange = new Box<>();
        Box<Apple> boxApple = new Box<>();
        Box<Apple> boxApple2 = new Box<>();

        boxApple.add(new Apple());
        boxApple.add(new Apple());
        System.out.println(boxApple.get(0));
        System.out.println(boxApple.getAll());

        boxOrange.add(new Orange());
//        boxOrange.add(new Apple()); error
        boxOrange.add(new Orange());

        System.out.println(boxApple.compare(boxOrange));
        System.out.println(boxOrange.compare(boxOrange));

        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());

        boxApple2.add(new Apple());
        boxApple.pourOver(boxApple2);
        System.out.println(boxApple.getAll());
        System.out.println(boxApple.giveAway());
        System.out.println(boxApple.getAll());

    }

}

