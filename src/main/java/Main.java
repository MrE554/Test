import interfaces.Movementable;
import interfaces.IObstacles;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args){
        Random random = new Random();
        IObstacles[] obstacles = new IObstacles[random.nextInt(20)];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = i % 2 == 0 ? new Track(random.nextInt(150)) : new Wall(random.nextInt(150));
        }

        Movementable[] movementables = new Movementable[random.nextInt(15)];
        for (int i = 0; i < movementables.length; i++) {
            Movementable movementable;
            int maxRunDistance = random.nextInt(150);
            int maxJumpDistance = random.nextInt(150);
            if (i % 3 == 0) {
                movementable = new Cat(maxRunDistance, maxJumpDistance);
            } else if (i % 3 == 1) {
                movementable = new Robot(maxRunDistance, maxJumpDistance);
            } else {
                movementable = new Human(maxRunDistance, maxJumpDistance);
            }
            movementables[i] = movementable;
        }

        Arrays.stream(obstacles).forEach(a ->
                Arrays.stream(movementables).forEach(b -> {
                    if (a instanceof Wall) {
                        b.printRunInfo(a.getMaxSize());
                    } else if (a instanceof Track) {
                        b.printJumpInfo(a.getMaxSize());
                    }
                }));
    }
}
