package Objects;

import generator.Playground;

import java.util.Scanner;

public class Player extends Entity implements canMove{

    @Override
    public void Move(Scanner scanner) {
        char value;
        int newX;
        int newY;
        loop:
        while (true) {
            value = (char) scanner.nextInt();
            switch (value) {
                case 'a':
                    newX = x - 1;
                    newY = y;
                    if (playground.checkValidMove(this, newX, newY)) {
                        changeCoordinate(newX, newY);
                        break loop;
                    } else {
                        System.out.println("You can`t move here");
                        break;
                    }
                case 's':
                    newX = x;
                    newY = y - 1;
                    if (playground.checkValidMove(this, newX, newY)) {
                        changeCoordinate(newX, newY);
                        break loop;
                    } else {
                        System.out.println("You can`t move here");
                        break;
                    }
                case 'd':
                    newX = x + 1;
                    newY = y;
                    if (playground.checkValidMove(this, newX, newY)) {
                        changeCoordinate(newX, newY);
                        break loop;
                    } else {
                        System.out.println("You can`t move here");
                        break;
                    }
                case 'w':
                    newX = x;
                    newY = y + 1;
                    if (playground.checkValidMove(this, newX, newY)) {
                        changeCoordinate(newX, newY);
                        break loop;
                    } else {
                        System.out.println("You can`t move here");
                        break;
                    }
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    public Player(int x, int y, Playground playground) {
        this.x = x;
        this.y = y;
        this.playground = playground;
        playground.setPlayer(this);
    }

}
