package Service;

import Model.Dimensions;
import Model.Point;
import Model.Polygon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class PolygonDrawer {
    public void drawPolygonPicture(Polygon polygon) {
        List<Point> points = polygon.getPoints();

        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (Point point : points) {
            xPoints[points.indexOf(point)] = point.getX();
            yPoints[points.indexOf(point)] = point.getY();
        }

        BufferedImage img = new BufferedImage(polygon.getDimensions().getWidth(), polygon.getDimensions().getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = img.createGraphics();
        graphics.setColor(Color.WHITE);

        graphics.drawPolygon(xPoints, yPoints, points.size());

        File polygonPicture = new File("output/polygon.png");
        try {
            javax.imageio.ImageIO.write(img, "PNG", polygonPicture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}