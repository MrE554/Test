import java.security.InvalidParameterException;

public class Plate extends Dish {
    public Plate(int amountOfFood) {
        addAmountOfFood(amountOfFood);
    }

    @Override
    public int getAmountOfFood() {
        return this.amountOfFood;
    }

    public void setAmountOfFood(int amount) {
        if (amount < 0) throw new InvalidParameterException("The amount of food cannot be negative");
        this.amountOfFood = amount;
    }

    @Override
    public void addAmountOfFood(int amount) {
        if (amount < 0) throw new InvalidParameterException("The amount of food cannot be negative");
        this.amountOfFood += amount;
    }
}
