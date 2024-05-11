package Model;

public class Dimensions {
    private int width;
    private int height;

    public Dimensions(int width, int height) {
        assert width > 0 : "Width must be greater than 0";
        assert height > 0 : "Height must be greater than 0";

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}