package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gob extends Biped{

    boolean skipMove = false;

    protected void attemptMove() {
        if ((int) (Math.random() * Gob.health()) % 2 == 0) {
            skipMove = true;
            if (skipMove) {
                skipMove = false;
                return;
            }
        }
    }

    public String iconGob() {
        return "\uD83D\uDC79";
    }
}




