package generator;

import Objects.Enemy;
import Objects.Entity;
import Objects.Player;
import drawer.Drawer;

import java.util.List;

public class Playground {
    private Map map;
    private Player player;
    private List<Enemy> enemies;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Playground(Map map, List<Enemy> enemies) {
        this.map = map;
        this.enemies = enemies;
    }

    public boolean checkGameEnd() {
        return map.isEndGame();
    }

    public boolean checkValidMove(Entity entity, int x, int y) {
        if (entity instanceof Player) {
            return map.isClearOrExit(x, y);
        } else {
            return map.isClear(x, y);
        }
    }

    public void changeCoordinate(int oldX, int oldY, int newX, int newY) {
        map.changeCoordinate(oldX, oldY, newX, newY);
    }
}
