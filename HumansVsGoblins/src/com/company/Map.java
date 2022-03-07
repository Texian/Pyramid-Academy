package com.company;

import java.util.ArrayList;
import com.company.Land;

public class Map {

    static int size = 10;
    private final String[][] board = new String[size][size];
    public ArrayList<Biped> characters = new ArrayList<Biped>();
    //private int turn = 0;

    public Map(){
    }

    public static void gameState() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.println("\uD83C\uDF33");
            }
        }

    }
}
