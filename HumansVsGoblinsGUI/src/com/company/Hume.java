package com.company;

public class Hume extends Biped {

    public String iconHume() {
        return "\uD83E\uDDCD";
    };

    private void checkGameOver() {
        int health = getHealth();
        if (health <= 0) {
            gameOver();
        }
    }
}
