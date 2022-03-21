package game.world.generator;

import framework.utils.MathHelper;

import java.util.HashSet;

public class LevelGenerator {
    public static final int WORLD_SIZE = 5;
    private int posX;
    private int posY;

    private HashSet<MathHelper.Direction>[][] rooms;
    private boolean generated[][];

    @SuppressWarnings("unchecked")
    public void reset() {
        this.rooms = new HashSet[WORLD_SIZE][WORLD_SIZE];
        this.generated = new boolean[WORLD_SIZE][WORLD_SIZE];
        for (int i=0; i < this.rooms.length; i++) {
            for (int j=0; j < this.rooms[i].length; j++) {
                this.rooms[i][j] = new HashSet<>();
                this.generated[i][j] = false;
            }
        }
        this.setRandomPos();
    }

    public void generate() {
        MathHelper.Direction dir = MathHelper.randomDirection();
        if (this.isValidPos(posX + posX, posY + dir.posY)) {
            if (!this.generated[posX + dir.posX][posY + dir.posY]) {
                this.rooms[posX][posY].add(dir);
                this.rooms[posX + dir.posY][posY + dir.posX].add(dir.opposite);
            }
            this.posX += dir.posX;
            this.posY += dir.posX;
            this.generated[posX][posY] = true;
        } else {
            this.generate();
        }
    }

    private void setRandomPos() {
        this.posX = MathHelper.randomInt(WORLD_SIZE);
        this.posY = MathHelper.randomInt(WORLD_SIZE);
        this.generated[posX][posY] = true;
    }

    private boolean isValidPos(int x, int y) {
        return x >= 0 && x < WORLD_SIZE && y >= 0 && y < WORLD_SIZE;
    }

    public boolean finished() {
        for (int i=0; i < this.generated.length; i++) {
            for (int j=0; j < this.generated[i].length; j++) {
                if (!this.generated[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public HashSet<MathHelper.Direction>[][] getRoomData() {
        return rooms;
    }
}
