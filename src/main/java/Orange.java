class Orange implements interfaces.Eatable {
    private int Weight = 2;

    @Override
    public int getWeight() {
        return Weight;
    }

    @Override
    public void setWeight(int weight) {
        this.Weight = weight;
    }
}
