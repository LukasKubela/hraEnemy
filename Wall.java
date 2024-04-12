package org.example.data;

import java.awt.*;

public class Wall {
    private Coordinates coordStart;
    private Coordinates coordEnd;
    private Color color;
    private boolean active;

    public Wall(int x1, int y1, int x2, int y2, Color color) {
        this.coordStart = new Coordinates(x1,y1);
        this.coordEnd = new Coordinates(x2,y2);
        this.color = color;
        this.active = true;
    }

    public void inactive(){
        active = false;
    }
    public void active(){
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getRectangle (){
        return new Rectangle(coordStart.x, coordStart.y, coordEnd.x - coordStart.x + 1,coordEnd.y - coordStart.y + 1);
    }

    public Coordinates getCoordStart() {
        return coordStart;
    }

    public Coordinates getCoordEnd() {
        return coordEnd;
    }

    public Color getColor() {
        return color;
    }
}
