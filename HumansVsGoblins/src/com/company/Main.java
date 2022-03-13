package com.company;

import java.util.ArrayList;
import java.util.List;
import static com.company.Map.*;

public class Main {

    public static void initBoard(){
        clearBoard();
        createCharacters();
        drawBoard();
        currentGameState();
    }

    public void updateGameBoard(){
        clearBoard();
        drawBoard();
    }

    public static void main(String[] args) {
        initBoard();
    }
}
