package drawer;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Colors {
    private Color enemy;
    private Color player;
    private Color empty;
    private Color goal;
    private Color wall;

    private static Colors instance = null;

    static Colors getInstance() {
        if (instance == null) {
            instance = new Colors();
        }
        return instance;
    }

    private Color getColorFromString(String in) {
        Color res = null;
        switch (in.toLowerCase()) {
            case "red":
                res = Color.red;
                break;
            case "green":
                res = Color.green;
                break;
            case "magenta":
                res = Color.magenta;
                break;
            case "blue":
                res = Color.blue;
                break;
            case "yellow":
                res = Color.yellow;
                break;
        }
        return res;
    }

    private Colors() {
        try {
            File file = new File(Colors.class.getResource("resources/Colors.txt").toURI());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String in = scanner.nextLine();
                String[] param = in.split("=");
                switch (param[0]) {
                    case "enemy.color":
                        enemy = getColorFromString(param[1].trim());
                        break;
                    case "player.color":
                        player = getColorFromString(param[1].trim());
                        break;
                    case "wall.color":
                        wall = getColorFromString(param[1].trim());
                        break;
                    case "goal.color":
                        goal = getColorFromString(param[1].trim());
                        break;
                    case "empty.color":
                        empty = getColorFromString(param[1].trim());
                        break;
                }
            }
        } catch (URISyntaxException | FileNotFoundException | RuntimeException e) {
            System.out.println("Use default colors");
            defaultColors();
        }
    }

    private void defaultColors() {
        enemy = Color.red;
        player = Color.green;
        wall = Color.magenta;
        goal = Color.blue;
        empty = Color.yellow;
    }

    public Color getEnemy() {
        return enemy;
    }

    public Color getPlayer() {
        return player;
    }

    public Color getEmpty() {
        return empty;
    }

    public Color getGoal() {
        return goal;
    }

    public Color getWall() {
        return wall;
    }


}
