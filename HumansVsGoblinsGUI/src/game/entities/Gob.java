package game.entities;

import framework.utils.MathHelper;
import game.world.Tile;

public class Gob extends Biped{

    public String iconGob() {
        return "\uD83D\uDC79";
    }

    private static final long serialVersionUID = 1L;

    private Hume target;
    private int health;
    private int strength;

    public Gob(byte id, int health, int strength, Hume target) {
        super(id, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7));
        super.speed = 2;
        this.target = target;
        this.health = health;
        this.strength = strength;
    }

    public Gob(Gob copy) {
        this(copy.getID(), copy.health, copy.strength, copy.target);
    }
    public void replaceRandomly() {
        super.x = MathHelper.randomInt(2, 14)* Tile.SIZE;
        super.y = MathHelper.randomInt(2, 7)*Tile.SIZE;
    }

    @Override
    public void move() {
        super.move();
        float angle = ((float) this.target.y - (float) super.y) / ((float) this.target.x - (float) super.x);
        if (angle < 1 && angle > -1) {
            if (this.target.x < super.x) {
                super.up = false;
                super.down = false;
                super.left = true;
                super.right = false;
            } else {
                super.up = false;
                super.down = false;
                super.left = false;
                super.right = true;
            }
        }
        else if(angle > 1 || angle < -1) {
            if (this.target.y < super.y) {
                super.up = true;
                super.down = false;
                super.left = false;
                super.right = false;
            } else {
                super.up = false;
                super.down = true;
                super.left = false;
                super.right = false;
            }
        } else {
            if (this.target.x < super.x) {
                super.left = true;
                super.right = false;
            } else {
                super.left = false;
                super.right = true;
            }
        }
    }

    @Override
    public void setUp(boolean up) {
        return;
    }
    @Override
    public void setDown(boolean down) {
        return;
    }
    @Override
    public void setLeft(boolean left) {
        return;
    }
    @Override
    public void setRight(boolean right) {
        return;
    }

    public int getHealth() {
        return health;
    }
    public void damage(int amount, MathHelper.Direction knockback){
        this.health-=amount;
        super.x+=knockback.x*90;
        super.y+=knockback.y*90;
    }
}




