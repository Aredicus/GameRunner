package drawer;

import generator.Map;

import java.awt.*;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

public class Drawer {
    private final Map map;
    private final Colors colors;

    private final Symbols symbols;

    public Drawer(Map map) {
        this.map = map;
        colors = Colors.getInstance();
        symbols = Symbols.getInstance();
    }

    public void colorOut(String symbol, Color color) {
        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();
        System.out.print(colorize(symbol, BACK_COLOR(red, blue, green)));
    }

    public void draw() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWeight(); j++) {
                switch (map.getSymbol(i, j)) {
                    case 'c':
                        colorOut(symbols.getEmpty(), colors.getEmpty());
                        break;
                    case 'g':
                        colorOut(symbols.getGoal(), colors.getGoal());
                        break;
                    case 'w':
                        colorOut(symbols.getWall(), colors.getWall());
                        break;
                    case 'e':
                        colorOut(symbols.getEnemy(), colors.getEnemy());
                        break;
                    case 'p':
                        colorOut(symbols.getPlayer(), colors.getPlayer());
                        break;
                }
            }
            System.out.println();
        }
    }
}
