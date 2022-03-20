package game.entities;

import framework.resources.Resources;
import framework.utils.MathHelper;

import java.awt.*;
import java.util.ArrayList;

public class Hume extends Biped {

    public String iconHume() {
        return "\uD83E\uDDCD";
    };

    private static final long serialVersionUID = 1L;

    private int health;
    private int maxHealth;
    private byte regenDelay;
    private int strength;
    private int armor;
    private byte attackTime;
    private byte damageTime;
    private int item;

    public Hume(byte id, int health, int strength, Hume target) {
        super(Resources.PLAYER, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7));
        super.speed = 2;
        this.health = 20;
        this.maxHealth = 20;
        this.strength = 3;
        this.armor = 0;
        this.attackTime = 0;
        this.damageTime = 0;
        this.item = 0;
    }

    public void randomReplace() {
        super.x = MathHelper.randomInt(2, 14)*Tile.SIZE;
        super.y = MathHelper.randomInt(2, 7)*Tile.SIZE;
    }

    public int getHP() {
        return health;
    }

    public int getHPMax() {
        return maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getArmor() {
        return armor;
    }

    public int getItem() { return item;}

    public void addArmor(int amount) {
        this.armor += amount;
        if(this.armor>this.strength) {
            this.armor = this.strength;
        }
    }

    public void heal(int amount) {
        this.health+=amount;
        if(this.health>this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public void regen() {
        if(this.health<this.maxHealth) {
            this.regenDelay++;
        } else {
            this.regenDelay = 0;
        }

        if(this.regenDelay==50) {
            this.health++;
            this.regenDelay = 0;
        }
    }

    @Override
    public void move() {
        if (this.attackTime == 0) {
            super.move();
            switch(super.facing){
                case NORTH: super.entityID = Resources.PLAYER_BACK; break;
                case SOUTH: super.entityID = Resources.PLAYER; break;
                case EAST: super.entityID = Resources.PLAYER_RIGHT; break;
                case WEST: super.entityID = Resources.PLAYER_LEFT; break;
            }
        }
    }

    public void decreaseTime() {
        if (this.attackTime > 0) {
            this.attackTime--;
        }
        if (this.damageTime > 0) {
            this.damageTime--;
        }
    }

    public void attack() {
        if (this.attackTime == 0) {
            this.attackTime = 30;
        }
    }

    public Rectangle getAttackBox() {
        if(this.attackTime == 20) {
            switch(super.facing){
                case NORTH: return new Rectangle(super.x, super.y - super.height, super.width, super.height);
                case SOUTH: return new Rectangle(super.x, super.y + super.height, super.width, super.height);
                case EAST: return new Rectangle(super.x + super.width, super.y, super.width, super.height);
                case WEST: return new Rectangle(super.x - super.width, super.y, super.width, super.height);
                default:
                    break;
            }
        }
        return new Rectangle(0, 0, 0, 0);
    }

    @Override
    public void render(Graphics g) {
        if((up || down || left || right) && this.attackTime == 0) {
            super.animDelay++;
            if(super.animDelay==70) {
                super.animDelay = 0;
                super.animFrame = (byte) (1 - super.animFrame);
            }
        }
        g.drawImage(Resources.TEXTURES.get(entityID + animFrame), super.x, super.y, super.width, super.height, null);
    }
    public void damage(int amount) {
        if(this.damageTime == 0) {
            this.health -= amount;
            this.damageTime = 50;
        }
    }
}