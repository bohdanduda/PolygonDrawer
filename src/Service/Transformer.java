package Service;

import Model.Dimensions;

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
}