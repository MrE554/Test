public abstract class Animal {
    protected Plate plate;
    protected boolean isHungry = true;
    protected int amountOfFoodToEat;

    public abstract boolean isHungry();
    protected abstract void setHungry(boolean isHungry);
    public abstract int getAmountOfFoodToEat();
    public abstract void setAmountOfFoodToEat(int amount);

    public abstract int eat();
}
