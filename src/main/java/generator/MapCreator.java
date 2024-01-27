package generator;

import Objects.Enemy;
import Objects.Exit;
import Objects.Player;

import java.util.List;
import java.util.Random;


//придумать логику создания карты
public class MapCreator {
    private static int size;
    private static Playground playground;

    static Random random = new Random();

    private static void setPlayer() {
        int x = Math.abs(random.nextInt()) % size;
        int y = Math.abs(random.nextInt()) % size;
        new Player(x, y, playground);
        playground.getMap().setSymbol(x, y, 'p');
    }

    private static void setGoal() {
        while (true) {
            int x = Math.abs(random.nextInt()) % size;
            int y = Math.abs(random.nextInt()) % size;
            if (playground.getMap().getSymbol(x, y) == 0) {
                playground.getMap().setSymbol(x, y, 'g');
                playground.getMap().setExit(new Exit(x, y));
                break;
            }
        }
    }

    private static void setPath() {
        Player player = playground.getPlayer();
        Exit exit = playground.getMap().getExit();
        int xMin = Math.min(player.getX(), exit.getX());
        int xMax = Math.max(player.getX(), exit.getX());
        int yMin = Math.min(player.getY(), exit.getY());
        int yMax = Math.max(player.getY(), exit.getY());
        while (xMin != xMax && yMin != yMax) {
            int in = random.nextInt() % 2;
            switch (in) {
                case 0:
                    if (xMin != xMax) {
                        xMin++;
                        playground.getMap().setSymbol(xMin, yMin, 'c');
                    }
                    break;
                case 1:
                    if (yMin != yMax) {
                        yMin++;
                        playground.getMap().setSymbol(xMin, yMin, 'c');
                    }
                    break;
            }
        }
    }

    private static void setEnemies() {
        ;
        List<Enemy> enemies = playground.getEnemies();
        for (Enemy enemy : enemies) {
            int n = size;
            while (true) {
                if (n == 0) throw new RuntimeException("Not correct parameters");
                n--;
                int x = Math.abs(random.nextInt()) % size;
                int y = Math.abs(random.nextInt()) % size;
                if (playground.getMap().getSymbol(x, y) == 0) {
                    playground.getMap().setSymbol(x, y, 'e');
                    enemy.setX(x);
                    enemy.setY(y);
                    enemy.setPlayer(playground.getPlayer());
                    break;
                }
            }
        }
    }

    private static void setWalls(int walls) {
        for (int i = 0; i < walls; i++) {
            int n = size;
            while (true) {
                if (n == 0) throw new RuntimeException("Not correct parameters");
                n--;
                int x = Math.abs(random.nextInt()) % size;
                int y = Math.abs(random.nextInt()) % size;
                if (playground.getMap().getSymbol(x, y) == 0) {
                    playground.getMap().setSymbol(x, y, 'w');
                    break;
                }
            }
        }
    }

    private static void setClear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playground.getMap().getSymbol(i, j) == 0) {
                    playground.getMap().setSymbol(i, j, 'c');
                }
            }
        }
    }

    private static boolean checkParameters(int walls) {
        return walls + playground.getEnemies().size() + 2 < size * size;
    }

    public static void MapInput(Playground playground, int walls) {
        try {
            MapCreator.playground = playground;
            size = playground.getMap().getHeight();
            if (checkParameters(walls)) {
                setPlayer();
                setGoal();
                setPath();
                setEnemies();
                setWalls(walls);
                setClear();
            } else {
                throw new RuntimeException("Not correct parameters");
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
