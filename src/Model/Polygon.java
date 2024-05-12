package Model;

import java.util.List;

public class Polygon {
    private Dimensions dimensions;
    private List<Point> points;

    public Polygon(Dimensions dimensions, List<Point> points) {
        assert dimensions != null : "Dimensions cannot be null";
        assert points != null : "Points cannot be null";
        assert points.size() > 2 : "Polygon must have at least 3 points";

        this.dimensions = dimensions;
        this.points = points;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public List<Point> getPoints() {
        return points;
    }
}