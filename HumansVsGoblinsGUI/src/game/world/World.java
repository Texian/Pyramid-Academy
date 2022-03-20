package game.world;

import framework.GUI.WindowManager;
import framework.utils.MathHelper;
import game.Init;
import game.entities.Biped;
import game.world.generator.LevelGenerator;
import game.world.generator.RoomData;

import javax.swing.text.html.parser.Entity;
import java.util.HashSet;

public class World {
    private Room[][] room;
    private int currX;
    private int currY;

    public World(HashSet<MathHelper.Direction>[][] data){
        this.room = new Room[data.length][data[0].length];
        for(int i = 0; i < LevelGenerator.WORLD_SIZE; i++){
            for(int j = 0; j < LevelGenerator.WORLD_SIZE; j++){
                for(RoomData data : Init.ROOM) {
                    if(data.getExit().equals(data.[i][j]))
                    this.room[i][j] = new Room(data);
                }
            }
        }
        this.currX = 0;
        this.currY = 0;
    }
    public Room getRoom(int x, int y){
        return room[x][y];
    }

    public Room getRoom(){
        return room[currX][currY];
    }

    public Room getRandom() {
        return room[MathHelper.randomInt(LevelGenerator.WORLD_SIZE)][MathHelper.randomInt(LevelGenerator.WORLD_SIZE)];
    }

    public void changeRoom(Biped player) {
        if(player.getCenterX() < 0) {
            this.currX--;
            player.setCenterX(WindowManager.WIDTH);
        }
        else if(player.getCenterX() > WindowManager.WIDTH) {
            this.currX++;
            player.setCenterX(0);
        }
        else if (player.getCenterY() < 0) {
            this.currY--;
            player.setCenterY(WindowManager.HEIGHT);
        }
        else if (player.getCenterY() > WindowManager.HEIGHT) {
            this.currY++;
            player.setCenterY(0);
        }
    }
}
