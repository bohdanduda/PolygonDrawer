package Manager;

import Model.Polygon;
import Service.PerimeterCalculator;
import Service.PolygonDrawer;
import Service.TextFileParser;
import Service.Transformer;

import java.util.List;
import java.util.Scanner;

public class PolygonManager {
    private Polygon polygon;
    private List<String> lines;
    private TextFileParser textFileParser;
    private Transformer transformer;
    private PerimeterCalculator perimeterCalculator;
    private PolygonDrawer polygonDrawer;

    public PolygonManager() {
        this.textFileParser = new TextFileParser();
        this.transformer = new Transformer();
        this.perimeterCalculator = new PerimeterCalculator();
        this.polygonDrawer = new PolygonDrawer();
    }

    public void getLines(Scanner scanner) {
        this.lines = this.textFileParser.getLines(scanner);
    }

    public double getPerimeter() {
        return this.perimeterCalculator.getPerimeter(this.polygon);
    }

    public void transformPolygon() {
        this.polygon = this.transformer.transformPolygon(this.lines);
    }

    public void drawPolygonPicture() {
        this.polygonDrawer.drawPolygonPicture(this.polygon);
    }
}