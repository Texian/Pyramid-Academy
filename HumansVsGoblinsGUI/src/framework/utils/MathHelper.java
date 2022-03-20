package framework.utils;

import java.util.Random;

public class MathHelper {

    private static final Random random = new Random();

    public static int randomInt(int upper) {
        return random.nextInt(upper);
    }

    public static int randomInt(int lower, int upper) {
        return random.nextInt((upper - lower) + 1) + lower;
    }

    public static Direction randomDirection() {
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    public enum Direction {
        NORTH(0, -1),
        SOUTH(0, 1),
        EAST(1, 0),
        WEST(-1, 0);

        public final int x;
        public final int y;
        public Direction opposite;

        static {
            NORTH.opposite = SOUTH;
            SOUTH.opposite = NORTH;
            EAST.opposite = WEST;
            WEST.opposite = EAST;
        }

        private Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
