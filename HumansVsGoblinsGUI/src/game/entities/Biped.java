package game.entities;

import framework.resources.Resources;
import framework.utils.MathHelper;

import java.awt.*;

public class Biped extends Rectangle {

    private static final long serialVersionUID = 1L;
    protected byte entityID;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;

    protected int speed;

    protected MathHelper.Direction facing;

    protected byte animFrame;
    protected byte animDelay;
    int health, strength;
    int[] position = new int[2];

    public Biped (byte id, int xPos, int yPos) {
        super(xPos*Tile.SIZE, yPos*Tile.SIZE, Tile.SIZE, Tile.SIZE);
        this.entityID = id;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.speed = 5;
        this.facing = MathHelper.Direction.SOUTH;
        this.animFrame = 0;
    }

    public byte getID () {
        return entityID;
    }

    public void move() {
        if (up) {
            super.y -= this.speed;
            facing = MathHelper.Direction.NORTH;
        }
        if (down) {
            super.y += this.speed;
            facing = MathHelper.Direction.SOUTH;
        }
        if (left) {
            super.x -= this.speed;
            facing = MathHelper.Direction.WEST;
        }
        if (right) {
            super.x += this.speed;
            facing = MathHelper.Direction.EAST;
        }
    }

    public void setMovingUp (boolean up) {
        this.up = up;
    }

    public void setMovingDown (boolean down) {
        this.down = down;
    }

    public void setMovingLeft (boolean left) {
        this.left = left;
    }

    public void setMovingRight (boolean right) {
        this.right = right;
    }

    public void setCenterX (int x) {
        super.x = x - super.width/2;
    }

    public void setCenterY (int y) {
        super.y = y - super.height/2;
    }

    public void render (Graphics g) {
        if(up || down || left || right) {
            this.animDelay++;
            if(this.animDelay == 70) {
                this.animDelay = 0;
                this.animFrame = (byte) (1- this.animFrame);
            }
        }
        g.drawImage(Resources.TEXTURES.get(entityID + animFrame), super.x, super.y, super.width, super.height, null);
    }

    public void handleCollision(Tile tile) {
        Rectangle intersection = this.intersection(tile);
        if(intersection.isEmpty() || !tile.isWall()) return;
        if(intersection.width > intersection.height) {
            if(this.y < tile.y) {
                this.y = tile.y - this.height;
            } else {
                this.y = tile.y + this.height;
            }
        } else {
            if(this.x < tile.x) {
                this.x = tile.x - this.width;
            } else {
                this.x = tile.x + this.width;
            }
        }

        public MathHelper.Direction getFacing() {
            return facing;
        }
    }

}
