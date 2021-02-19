import interfaces.IObstacles;

public class Wall implements IObstacles {
    private int maxSizeTrack;

    public Wall(int maxSizeTrack) {
        this.maxSizeTrack = maxSizeTrack;
    }

    public int getMaxSize() {
        return maxSizeTrack;
    }

    public void setMaxSizeTrack(int maxSizeTrack) {
        this.maxSizeTrack = maxSizeTrack;
    }
}
