package game.world.generator;

import framework.resources.Resources;
import framework.utils.MathHelper;
import game.world.Tile;

import java.awt.*;
import java.util.HashSet;

public class RoomData {
    private Tile[][] tileData;

    private HashSet<MathHelper.Direction> exit;

    public RoomData(byte[][] tileData, MathHelper.Direction... exits) {
        this.tileData = new Tile[tileData.length][tileData[0].length];
        for (int i = 0; i < this.tileData.length; i++) {
            for (int j = 0; j < this.tileData[i].length; j++) {
                this.tileData[i][j] = new Tile(tileData[i][j], j, i, tileData[i][j] == 1 || tileData[i][j] == 2);
            }
        }
        this.exit = new HashSet<>();
        for (MathHelper.Direction direction : exits) {
            this.exit.add(direction);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < this.tileData.length; i++) {
            for (int j = 0; j < this.tileData[i].length; j++) {
                g.drawImage(Resources.TEXTURES.get(this.tileData[i][j].getID()), j * Tile.SIZE, i * Tile.SIZE, Tile.SIZE, Tile.SIZE, null);
            }
        }
    }

    public HashSet<MathHelper.Direction> getExit() {
        return exit;
    }

    public Tile getTileAt(int x, int y) {
        return tileData[x][y];
    }

    public int getWidth() {
        return tileData.length;
    }

    public int getHeight() {
        return tileData[0].length;
    }
}
