package Service;

import Model.Point;
import Model.Polygon;

import java.util.List;

public class PerimeterCalculator {
    public double getPerimeter(Polygon polygon) {
        List<Point> points = polygon.getPoints();
        double perimeter = 0;

        for (int i = 0; i < points.size(); i++) {
            Point point1 = points.get(i);
            Point point2 = points.get((i + 1) % points.size());
            perimeter += getLineLength(point1, point2);
        }

        return Math.round(perimeter * 100.0) / 100.0;
    }

    private double getLineLength(Point point1, Point point2){
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }
}
