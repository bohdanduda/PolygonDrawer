import Model.Dimensions;
import Model.Point;
import Model.Polygon;
import Service.PerimeterCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerimeterCalculatorTest {
    @Test
    public void testCalculatePerimeter() {
        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(5, 5));
        points.add(new Point(5, 0));
        points.add(new Point(0, 0));

        Polygon polygon = new Polygon(new Dimensions(10, 10), points);

        assertEquals(20, perimeterCalculator.getPerimeter(polygon));
    }

    @Test
    public void testCalculatePerimeter2() {
        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();

        List<Point> points = new ArrayList<>();
        points.add(new Point(10,10));
        points.add(new Point(90,10));
        points.add(new Point(90,90));
        points.add(new Point(10,90));
        points.add(new Point(10,10));

        Polygon polygon = new Polygon(new Dimensions(100,100), points);

        assertEquals(320, perimeterCalculator.getPerimeter(polygon));
    }

    @Test
    public void testCalculatePerimeter_Triangle() {
        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(50, 99));
        points.add(new Point(25, 30));

        Polygon polygon = new Polygon(new Dimensions(100,100), points);

        assertEquals(223.35, perimeterCalculator.getPerimeter(polygon));
    }


}