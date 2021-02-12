public class Cat extends Animal {
    public Cat(int amountOfFoodToEat) {
        setAmountOfFoodToEat(amountOfFoodToEat);
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    @Override
    public boolean isHungry() {
        return this.isHungry;
    }

    @Override
    protected void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    @Override
    public int getAmountOfFoodToEat() {
        return this.amountOfFoodToEat;
    }

    @Override
    public void setAmountOfFoodToEat(int amount) {
        this.amountOfFoodToEat = amount;
    }

    @Override
    public int eat() {
        int amountOfFood = this.plate.getAmountOfFood();
        int amountOfFoodToEat = this.getAmountOfFoodToEat();

        if (amountOfFood >= amountOfFoodToEat) {
            amountOfFood -= amountOfFoodToEat;
            System.out.println("Кот есъел " + (this.plate.getAmountOfFood() - amountOfFood));
            setHungry(false);
        } else {
            System.out.println("Кот ничего не съел так, как мало еды");
        }

        return amountOfFood;
    }

}
