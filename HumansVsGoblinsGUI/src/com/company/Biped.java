package com.company;

public class Biped {

    int health, strength;
    int[] position = new int[2];

    public Biped() {}

    public Biped (int health, int strength, int[] position) {
        this.health = health;
        this.strength = strength;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }
}
