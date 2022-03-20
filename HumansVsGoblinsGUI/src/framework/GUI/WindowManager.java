package framework.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class WindowManager {

    private JFrame frame;
    private JPanel panel;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public WindowManager() {
        frame = new JFrame("Humans VS Goblins");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void addPanel(JPanel panel) {
        this.panel = panel;
        this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.panel.setFocusable(true);
        this.panel.requestFocusInWindow();
    }

    public void addKeyListener(KeyListener listener) {
        try {
            panel.addKeyListener(listener);
        } catch (NullPointerException e) {
            System.out.println("Panel not added yet");
            System.exit(-1);
        }
    }

    public void createWindow() {
        this.frame.setContentPane(panel);
        this.frame.pack();
        this.frame.setVisible(true);
    }
}
