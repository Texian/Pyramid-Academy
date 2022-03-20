package framework.gamestates;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {
    private Stack<GameState> states;

    public GameStateManager() {
        this.states = new Stack<>();
    }

    public void stackState(GameState state) {
        this.states.add(state);
    }

    public void previousState() {
        this.states.pop();
    }

    public void clearStack() {
        this.states.clear();
    }

    public void update() {
        try {
            this.states.peek().update();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void render(Graphics g) {
        try {
            this.states.peek().render(g);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void keyPressed(int k) {
        try {
            this.states.peek().keyPressed(k);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void keyReleased(int k) {
        try {
            this.states.peek().keyReleased(k);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }
}
