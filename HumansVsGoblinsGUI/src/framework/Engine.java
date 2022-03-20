package framework;

import framework.GUI.WindowManager;
import framework.gamestates.GameStateManager;
import game.states.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine {
    private static GameStateManager gsManager;
    private static WindowManager wManager;
    private static Timer timer;

    public static void init(){
        gsManager = new GameStateManager();
        wManager = new WindowManager();
        timer = new Timer(20, new MainLoop());
    }

    public static void start(){
        gsManager.stackState(new MainMenu(gsManager));
        wManager.addPanel(new GameScreen());
        wManager.addKeyListener(new Keyboard());
        wManager.createWindow();
        timer.start();
    }

    private static class MainLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0){
            gsManager.update();
        }
    }

    private static class GameScreen extends JPanel{
        //private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            gsManager.render(g);
            repaint();
        }
    }

    private static class Keyboard implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e){
            gsManager.keyPressed(e.getKeyCode());
        }
        @Override
        public void keyReleased(KeyEvent e){
            gsManager.keyReleased(e.getKeyCode());
        }
        @Override
        public void keyTyped(KeyEvent arg0){}
    }
}
