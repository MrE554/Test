import interfaces.IObstacles;

public class Track implements IObstacles {
    private int maxSizeTrack;

    public Track(int maxSizeTrack) {
        this.maxSizeTrack = maxSizeTrack;
    }

    public int getMaxSize() {
        return maxSizeTrack;
    }

    public void setMaxSizeTrack(int maxSizeTrack) {
        this.maxSizeTrack = maxSizeTrack;
    }
}
