package Service;

import Model.Dimensions;
import Model.Point;

public class Transformer {
    public Dimensions transformDimensions(String dimensionsInText) {
        String[] dimensions = dimensionsInText.split("x");

        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Invalid dimension format. Expected format: <width>x<height>");
        }

        if (Integer.parseInt(dimensions[0]) <= 0 || Integer.parseInt(dimensions[1]) <= 0) {
            throw new IllegalArgumentException("Invalid dimension. Width and height must be greater than 0.");
        }

        return new Dimensions(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
    }

    public Point transformPoint(String pointInText, Dimensions dimensions) {
        String[] arrPoints = pointInText.split(",");

        if (arrPoints.length != 2) {
            throw new IllegalArgumentException("Invalid dimension format. Expected format: <width>x<height>");
        }

        String x = arrPoints[0];
        String y = arrPoints[1];

        int xValue = calculateCoordinate(x, dimensions.getWidth(), 'L', 'C', 'R');
        int yValue = calculateCoordinate(y, dimensions.getHeight(), 'T', 'C', 'B');

        return new Point(xValue, yValue);
    }

    private int calculateCoordinate(String coordinate, int maxValue, char defaultRef, char centerRef, char endRef) {
        char reference = defaultRef;
        int value;
        int center = Math.round((float) maxValue / 2);

        if (Character.isLetter(coordinate.charAt(0))) {
            if (coordinate.charAt(0) != 'L' && coordinate.charAt(0) != 'T' && coordinate.charAt(0) != 'C' && coordinate.charAt(0) != 'R' && coordinate.charAt(0) != 'B') {
                throw new IllegalArgumentException("Invalid default reference. Expected values: L, T, C, R, B");
            }
            reference = coordinate.charAt(0);
            value = Integer.parseInt(coordinate.substring(1));
        } else {
            value = Integer.parseInt(coordinate);
        }

        if (reference == defaultRef && value < 0) {
            throw new IllegalArgumentException("Invalid coordinate");
        }

        if (reference == endRef && value > 0) {
            throw new IllegalArgumentException("Invalid coordinate");
        }

        if (reference == defaultRef) {
            return value;
        }

        if (reference == centerRef) {
            return center + value;
        }

        return maxValue + value;
    }
}