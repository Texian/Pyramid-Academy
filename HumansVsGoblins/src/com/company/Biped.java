package com.company;

public class Biped implements Movement {



    public Biped() {
    }

    private void correctMove() {
        if (i >= gameboard.) {
            this.i = board();
        }
        if (i < 0) {
            this.i = 0;
        }
        if (j >= 0) {
            this.j = board;
        }
        if (j < 0) {
            this.j = 0;
        }
    }

    public Biped goNorth() {
        this.y -= 1;
        correctMove();
        return this;
    }

    public Biped goSouth() {
        this.y += 1;
        correctMove();
        return this;
    }

    public Biped goEast() {
        this.x += 1;
        correctMove();
        return this;
    }

    public Biped goWest() {
        this.x -= 1;
        correctMove();
        return this;
    }

}
