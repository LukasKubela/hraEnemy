package org.example;

import org.example.data.Ball;
import org.example.data.Direction;
import org.example.data.Wall;


import java.awt.*;
import java.util.ArrayList;

public class GameData {
    private Ball ball;
    private ArrayList<Wall> walls;

    public GameData() {
        walls = new ArrayList<>();
    }

    public void update() {
        ball.move(5, Direction.RIGHT);
        for (Wall wall: walls) {
            if (ball.isColided(wall.getRectangle())){
                wall.inactive();
            }
        }
    }

    public void initialize() {
        ball = new Ball(20, 20, 50, 50, Color.BLUE);

        Wall wall1 = new Wall(200, 30, 200, 80, Color.BLACK);
        Wall wall2 = new Wall(400, 100, 500, 100, Color.BLACK);

        walls.add(wall1);
        walls.add(wall2);

    }

    public Ball getBall() {
        return ball;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }
}