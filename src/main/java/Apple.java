import interfaces.Eatable;

class Apple implements Eatable {
    private int Weight = 1;

    @Override
    public int getWeight() {
        return Weight;
    }

    @Override
    public void setWeight(int weight) {
        this.Weight = weight;
    }
}
