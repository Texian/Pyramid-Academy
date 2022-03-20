package game.states;

import framework.GUI.WindowManager;
import framework.gamestates.GameState;
import framework.gamestates.GameStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends GameState {
    private String[] options;
    private static final String START_GAME = "Start Game";
    private static final String QUIT_GAME = "Quit Game";
    private int selected;

    public MainMenu(GameStateManager gsManager) {
        super(gsManager);
        this.options = new String[] {START_GAME, QUIT_GAME};
        this.selected = 0;
    }

    @Override
    protected void loop() {
    }

    @Override
    protected void render(Graphics graphics) {
        graphics.setColor(new Color(30, 30, 70));
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

        graphics.setFont(new Font("Arial", Font.PLAIN, 25));
        for(int i = 0; i < options.length; i++) {
            if(i == this.selected) {
                graphics.setColor(Color.GREEN);
            } else {
                graphics.setColor(Color.WHITE);
            }
            graphics.drawString(this.options[i], WindowManager.WIDTH / 2 - 50, WindowManager.HEIGHT / 2 + i * 30);
        }
    }

    @Override
    protected void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_UP:
                if(this.selected > 0) this.selected--;
                break;
            case KeyEvent.VK_DOWN:
                if(this.selected < this.options.length - 1) this.selected++;
                break;
            case KeyEvent.VK_ENTER:
                switch(this.options.[selected]) {
                    case START_GAME:
                        this.gsManager.stackState(new PlayingState(gsm));
                        break;
                    case QUIT_GAME:
                        System.exit(0);
                        break;
                }
                break;
            }
    }

    @Override
    protected void keyReleased(int keyCode) {
    }
}
