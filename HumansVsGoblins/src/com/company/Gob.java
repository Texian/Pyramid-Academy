package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gob extends Biped{

    //private boolean skipMove = false;

//    @Override
//    public String toString(){
//        return "\uD83D\uDC79";
//    }

//    int RandomPosition() {
//        List<Integer> gridPositions = new ArrayList<>();
//        return gridPositions;
//    }

    public String iconGob() {
        return "\uD83D\uDC79";
    };
//    public Gob(int health, int strength, int x, int y) {
//        super(x,y);
//        this.health = health;
//        this.strength = strength;
//    }
//
//    public void getHealth() {
//        return health;
//    }
//
//    public int getHealth(int health) {
//        this.health = health;
//    }
//
//    public void getStrength() {
//        return strength;
//    }
//
//    public int getStrength(int strength) {
//        this.strength = strength;
//    }
//
//    protected void attemptMove(int dirX, int dirY){
//        if (skipMove) {
//            skipMove = false;
//            return;
//        }
//
//        goSouth().goWest().goWest().goNorth().goEast();
//
//        if ((int) (Math.random() * Gob.health()) % 2 == 0) {
//            skipMove = true;
//        }
//    }
}
