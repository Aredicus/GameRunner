package Objects;

import java.util.Random;
import java.util.Scanner;


//добавить проверку действия при профиле
public class Enemy extends Entity implements canMove {
    private Player player;

    private boolean profile;

    public Enemy(String profile) {
        this.profile = profile.equals("production");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //Доделать профиль
    @Override
    public void Move(Scanner scanner) {
        int xGoal = player.x;
        int yGoal = player.y;
        int n = 4;
        loop:
        while (n != 0) {
            Random random = new Random();
            int in = Math.abs(random.nextInt()) % 2;
            switch (in) {
                case 0:
                    if (xGoal > x) {
                        if (playground.checkValidMove(this, x + 1, y)) {
                            changeCoordinate(x + 1, y);
                            break loop;
                        } else if (playground.checkValidMove(this, x - 1, y)) {
                            changeCoordinate(x, y + 1);
                            break loop;
                        }
                    } else if (xGoal < x) {
                        if (playground.checkValidMove(this, x - 1, y)) {
                            changeCoordinate(x, y + 1);
                            break loop;
                        } else if (playground.checkValidMove(this, x + 1, y)) {
                            changeCoordinate(x + 1, y);
                            break loop;
                        }
                    }
                    break;
                case 1:
                    if (yGoal > y) {
                        if (playground.checkValidMove(this, x, y + 1)) {
                            changeCoordinate(x, y + 1);
                            break loop;
                        } else if (playground.checkValidMove(this, x, y - 1)) {
                            changeCoordinate(x, y - 1);
                            break loop;
                        }
                    } else if (yGoal < y) {
                        if (playground.checkValidMove(this, x, y - 1)) {
                            changeCoordinate(x, y - 1);
                            break loop;
                        } else if (playground.checkValidMove(this, x, y + 1)) {
                            changeCoordinate(x, y + 1);
                            break loop;
                        }
                    }
                    break;
            }
            n--;
        }
    }
}
