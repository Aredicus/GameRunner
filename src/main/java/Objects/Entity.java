package Objects;

import generator.Playground;

import java.util.Scanner;

public abstract class Entity {

    protected Playground playground;
    protected int x;
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeCoordinate(int x, int y) {
        playground.changeCoordinate(this.x, this.y, x, y);
        this.x = x;
        this.y = y;
    }
}
