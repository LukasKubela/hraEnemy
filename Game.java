package org.example;

import org.example.data.Direction;
import org.example.data.Enemy;
import org.example.data.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game {
    GameData data;
    private ArrayList<Enemy> enemies;
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        data = new GameData();
        enemies = new ArrayList<>();
        createEnemies();

        GameGraphics graphics = new GameGraphics(enemies);

        data.initialize();
        graphics.render(data);

        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY() - graphics.getInsets().top;
                int ballX = data.getBall().getX();
                int ballWidth = data.getBall().getWidth();
                int ballY = data.getBall().getY();
                int ballHeight = data.getBall().getHeight();
                if (clickX > ballX && clickX < ballX + ballWidth){
                    if (clickY > ballY && clickY < ballY+ballHeight){
                        data.getBall().move(50,Direction.RIGHT);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                data.update();
                moveEnemies();
                detectCollision();
                graphics.render(data);
            }
        });

        timer.start();

    }

    private void createEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new Enemy(250, 200, 50, 50, Color.RED, 0, -5));
        enemies.add(new Enemy(400, 200, 50, 50, Color.RED, 0, -5));
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.move();
            detectEnemyWallCollision(enemy);
        }
    }

    private void detectEnemyWallCollision(Enemy enemy) {
        for (Wall wall : data.getWalls()) {
            Rectangle enemyRect = enemy.getEnemyRectangle();
            Rectangle wallRect = wall.getRectangle();
            if (enemyRect.intersects(wallRect)) {
                enemy.stop();
                break;
            }
        }
    }

    private void detectCollision() {
        Rectangle playerRect = data.getBall().getBallRectangle();
        for (Enemy enemy : enemies) {
            Rectangle enemyRect = enemy.getEnemyRectangle();
            if (playerRect.intersects(enemyRect)) {
                System.exit(0);
            }
        }
    }
}