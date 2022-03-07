package com.company;

public class Biped implements Movement {

    int row, col, health, strength;

    public Biped() {}

    public Biped (int row, int col, int health, int strength){
        this.row = row;
        this.col = col;
        this.health = health;
        this.strength = strength;
    }

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getCol(){
        return col;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
