package generator;

import Objects.Exit;


// p - player
// e - enemy
// g - goal
// w - wall
// c - clear
public class Map {
    private Exit exit;
    private int height;
    private int weight;

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    private char[][] map;


    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Map(int height, int weight) {
        map = new char[weight][height];
        this.height = height;
        this.weight = weight;
    }

    public boolean isEndGame() {
        return map[exit.getX()][exit.getY()] == 'p';
    }

    public boolean isClear(int x, int y) {
        return map[x][y] == 'c';
    }

    public boolean isClearOrExit(int x, int y) {
        return map[x][y] == 'g' || map[x][y] == 'c';
    }

    public void changeCoordinate(int oldX, int oldY, int newX, int newY) {
        map[newX][newY] = map[oldX][oldY];
        map[oldX][oldY] = 'c';
    }

    public Exit getExit() {
        return exit;
    }

    public void setSymbol(int i, int j, char symbol) {
        map[i][j] = symbol;
    }

    public char getSymbol(int i, int j) {
        return map[i][j];
    }
}
