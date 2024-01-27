package drawer;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Symbols {
    private String enemy;
    private String player;
    private String empty;
    private String goal;
    private String wall;


    private static Symbols instance = null;

    private Symbols() {
        try {
            File file = new File(Colors.class.getResource("resources/Symbols.txt").toURI());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String in = scanner.nextLine();
                String[] param = in.split(" = ");
                if (param.length < 2) {
                    throw new RuntimeException("Not correct parameters to symbols");
                }
                switch (param[0]) {
                    case "enemy.color":
                        enemy = param[1];
                        break;
                    case "player.color":
                        player = param[1];
                        break;
                    case "wall.color":
                        wall = param[1];
                        break;
                    case "goal.color":
                        goal = param[1];
                        break;
                    case "empty.color":
                        empty = param[1];
                        break;
                }
            }
        } catch (URISyntaxException | FileNotFoundException | RuntimeException e) {
            System.out.println("Use default symbols");
            defaultSymbols();
        }
    }

    public void defaultSymbols() {
        enemy = "X";
        player = "o";
        wall = "#";
        goal = "O";
        empty = " ";
    }

    public static Symbols getInstance() {
        if (instance == null) {
            instance = new Symbols();
        }
        return instance;
    }


    public String getEnemy() {
        return enemy;
    }

    public String getPlayer() {
        return player;
    }

    public String getEmpty() {
        return empty;
    }

    public String getGoal() {
        return goal;
    }

    public String getWall() {
        return wall;
    }
}
