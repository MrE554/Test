import interfaces.Movementable;

public class Human implements Movementable {
    private final String name = "Alexsey";
    private final int maxRunDistance;
    private final int maxJumpDistance;

    public Human(int maxRunDistance, int maxJumpDistance) {
        this.maxJumpDistance = maxJumpDistance;
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxRunDistance() {
        return this.maxRunDistance;
    }

    public int getMaxJumpDistance() {
        return this.maxJumpDistance;
    }

    @Override
    public void printJumpInfo(int lengthWall) {
        if(lengthWall <= getMaxJumpDistance()){
            System.out.println("Человек перепрыгнул стену, рамер которого " + lengthWall);
        } else {
            System.out.println("Человек не смог перепрыгнуть предпятсвие, размер которого " + lengthWall);
        }
    }

    @Override
    public void printRunInfo(int lengthRunningStrip) {
        if(lengthRunningStrip <= getMaxRunDistance()){
            System.out.println("Человек перебежал беговую полосу, рамер которого " + lengthRunningStrip);
        } else {
            System.out.println("Человек не смог перебежал беговую полосу, размер которого " + lengthRunningStrip);
        }
    }
}
