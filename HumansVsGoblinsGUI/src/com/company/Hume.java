package com.company;

import java.util.ArrayList;

public class Hume extends Biped {

    public String iconHume() {
        return "\uD83E\uDDCD";
    };
    ArrayList<String> inventory = new ArrayList<>();

    Hume(int health, int strength, int[] position) {
        super(health, strength, position);
        this.health = health;
        this.strength = strength;
    }

    public void move(int[] newPosition) {
        position[0] = newPosition[0];
        position[1] = newPosition[1];
    }

    public String attack(Gob gob, Hume hume) {
        int damage = (int) (Math.random() * hume.strength) + 1;
        gob.health -= damage;
        return "Hume attacks " + gob.iconGob() + " for " + damage + " damage.";
    }
}
