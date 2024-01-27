import Objects.Enemy;
import Objects.Player;
import com.beust.jcommander.JCommander;
import drawer.Drawer;
import drawer.Symbols;
import generator.Map;
import generator.MapCreator;
import generator.Playground;
import parameters.Args;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Args jArgs = new Args();
        JCommander.newBuilder().addObject(jArgs).build().parse(args);
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < jArgs.getEnemies(); i++) {
            enemies.add(new Enemy(jArgs.getProfile()));
        }
        Playground playground = new Playground(new Map(jArgs.getSize(), jArgs.getSize()), enemies);
        try {
            MapCreator.MapInput(playground, jArgs.getWalls());
            Drawer drawer = new Drawer(playground.getMap());
            drawer.draw();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void game(Drawer drawer, Playground playground) {
        Scanner scanner = new Scanner(System.in);
        while (!playground.checkGameEnd()) {
            playground.getPlayer().Move(scanner);
            for (Enemy enemy : playground.getEnemies()) {
                enemy.Move(scanner);
            }
        }
    }
}
