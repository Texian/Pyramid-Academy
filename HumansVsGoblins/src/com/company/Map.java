package com.company;

import java.util.ArrayList;
import com.company.Land;

public class Map {

    static int size = 10;
    private static final String[][] board = new String[size][size];
    private int turn = 0;
    private ArrayList<Biped> bipeds = new ArrayList<Biped>();
    static Land tree = new Land();

    public Map(){}

    public static void clearBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = null;
            }
        }
    }

    public static void drawBoard() {
        //String tree = "\uD83C\uDF33";
        for (int i = 0; i < size; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(tree);
            }
            System.out.println();
        }
    }
    public static void currentGameState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(tree);
                } else {
                    System.out.print(board[i][j].getBipedName());
                }
            }
        }
    }

    static ArrayList<Biped> getBipeds(){return bipeds;}

    public static void createCharacters() {
        ArrayList<Biped> bipeds = getBipeds();
        for(Biped b : bipeds){
            board[b.getRow()][b.getCol()] = b;
        }
    }

    public void removePiece(int r, int c){
        ArrayList<Biped> bipeds = getBipeds();
        for(Biped b : bipeds){
            if(b.getRow() == r && b.getCol() == c){
                bipeds.remove(b);
                updateBipeds(bipeds);
                updateGameBoard();
                break;
            }
        }
    }

    public void addPiece(Biped b, int r, int c){
        ArrayList<Biped> bipeds = getBipeds();
        if(!bipedOnSpace(r, c)){
            bipeds.add(b);
            updateBipeds(bipeds);
            updateGameBoard();
        } else {
            System.out.println("There is already a piece in this space! You cannot add a piece here.");
        }
    }
}
