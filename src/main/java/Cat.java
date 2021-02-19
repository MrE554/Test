import interfaces.Movementable;

public class Cat implements Movementable {
    private final int maxRunDistance;
    private final int maxJumpDistance;

    public Cat(int maxRunDistance, int maxJumpDistance) {
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
            System.out.println("Кот перепрыгнул стену, рамер которого " + lengthWall);
        } else {
            System.out.println("Кот не смог перепрыгнуть предпятсвие, размер которого " + lengthWall);
        }
    }

    @Override
    public void printRunInfo(int lengthRunningStrip) {
        if(lengthRunningStrip <= getMaxRunDistance()){
            System.out.println("Кот перебежал беговую полосу, рамер которого " + lengthRunningStrip);
        } else {
            System.out.println("Кот не смог перебежал беговую полосу, размер которого " + lengthRunningStrip);
        }
    }
}

