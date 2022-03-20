package framework.gamestates;

import java.awt.*;

public abstract class GameState {
    protected GameStateManager gsManager;
    protected GameState(GameStateManager gsManager) {
        this.gsManager = gsManager;
    }

    protected abstract void loop();
    protected abstract void render(Graphics graphics);
    protected abstract void keyPressed(int keyCode);
    protected abstract void keyReleased(int keyCode);
}
