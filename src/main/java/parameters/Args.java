package parameters;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;


@Parameters(separators = "=")
public class Args {
    @Parameter(names = "--size")
    private Integer size;

    @Parameter(names = "--wallsCount")
    private Integer walls;

    @Parameter(names = "--enemiesCount")
    private Integer enemies;

    @Parameter(names = "--profile")
    private String profile;

    public Integer getSize() {
        return size;
    }

    public Integer getWalls() {
        return walls;
    }

    public Integer getEnemies() {
        return enemies;
    }

    public String getProfile() {
        return profile;
    }
}
