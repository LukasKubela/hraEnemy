package org.example;

import javax.swing.*;
import java.awt.*;

import org.example.data.Enemy;
import org.example.data.Wall;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class GameGraphics extends JFrame {
    GameData data;
    private ArrayList<Enemy> enemies;

    public GameGraphics(ArrayList<Enemy> enemies) throws HeadlessException {
        this.enemies = enemies;
        Draw draw = new Draw();
        add(draw);

        this.data = null;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(GameData data) {
        this.data = data;
        repaint();
    }

    class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (data != null) {
                g.setColor(data.getBall().getColor());
                g.fillOval(data.getBall().getX(), data.getBall().getY(), data.getBall().getWidth(), data.getBall().getHeight());

                if (enemies != null) {
                    for (Enemy enemy : enemies) {
                        g.setColor(enemy.getColor());
                        g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                    }
                }

                for (Wall wall: data.getWalls()){
                    if (wall.isActive()) {
                        g.setColor(wall.getColor());
                        g.drawLine(wall.getCoordStart().x,wall.getCoordStart().y, wall.getCoordEnd().x, wall.getCoordEnd().y);
                    }

                }

            }

        }
    }

}