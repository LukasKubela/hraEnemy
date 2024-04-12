package org.example.data;

import java.awt.*;

public class Enemy {private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int speedX;
    private int speedY;

    public Enemy(int x, int y, int width, int height, Color color, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move() {
        // Pohyb nepřátel - jednoduchý pohyb doleva a doprava
        x += speedX;
        y += speedY;

        // Doplnění kódu pro detekci kolize s hranami okna nebo jinými překážkami
    }

    public Rectangle getEnemyRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void stop() {
        speedX = 0;
        speedY = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }
}

