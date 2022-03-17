package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gob extends Biped{

    public String iconGob() {
        return "\uD83D\uDC79";
    }

    Gob(int health, int strength, int[] position) {
        super(health, strength, position);
        this.health = health;
        this.strength = strength;
    }

    boolean skipMove = false;

    protected void attemptMove(Gob gob, int[] newPosition) {
        if ((int) (Math.random() * gob.health) % 2 == 0) {
            skipMove = true;
            if (skipMove) {
                skipMove = false;
                return;
            } else {
                position[0]= newPosition[0];
                position[1]= newPosition[1];
            }
        }
    }

    public String attack(Gob gob, Hume hume) {
        int damage = (int) (Math.random() * gob.strength) + 1;
        hume.health -= damage;
        return "Gob attacks " + hume.iconHume() + " for " + damage + " damage.";
    }
}




