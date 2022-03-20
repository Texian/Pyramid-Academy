package game.world;

import java.awt.*;

public class Tile extends Rectangle {
    private static final long serialVersionUID = 1L;
    public static final int SIZE = 50;
    private byte id;
    private boolean wall;

    public Tile(byte id, int posX, int posY, boolean isWall) {
        super(posX * SIZE, posY * SIZE, SIZE, SIZE);
        this.id = id;
        this.wall = isWall;
    }

    public byte getId() {
        return id;
    }

    public boolean isWall() {
        return wall;
    }
}
