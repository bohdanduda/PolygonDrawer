import Model.Dimensions;
import Model.Point;
import Service.Transformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransformerTest {

    @Test
    public void testTransformDimensions() {
        Transformer transformer = new Transformer();
        Dimensions expected = new Dimensions(10, 20);
        Dimensions actual = transformer.transformDimensions("10x20");
        assertEquals(expected.getWidth(), actual.getWidth());
        assertEquals(expected.getHeight(), actual.getHeight());
    }

    @Test
    public void testTransformDimensionsWithInvalidFormat() {
        Transformer transformer = new Transformer();
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformDimensions("10-20");
        });
    }

    @Test
    public void testTransformDimensionsWithNegativeValues() {
        Transformer transformer = new Transformer();
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformDimensions("-10x-20");
        });
    }

    @Test
    public void testTransformPoint_DefaulRef() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        Point expected = new Point(0, 10);
        Point actual = transformer.transformPoint("0,10", dimensions);
        assertEquals(expected.getX(), actual.getX());
        assertEquals(expected.getY(), actual.getY());
    }

    @Test
    public void testTransformPoint_CenterRef() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        Point expected = new Point(10, 5);
        Point actual = transformer.transformPoint("C5,C-5", dimensions);
        assertEquals(expected.getX(), actual.getX());
        assertEquals(expected.getY(), actual.getY());
    }

    @Test
    public void testTransformPoint_EndRef() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        Point expected = new Point(5, 15);
        Point actual = transformer.transformPoint("R-5,B-5", dimensions);
        assertEquals(expected.getX(), actual.getX());
        assertEquals(expected.getY(), actual.getY());
    }

    @Test
    public void testTransformPoint_DefaulRef_Invalid() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformPoint("-5,-10", dimensions);
        });
    }

    @Test
    public void testTransformPoint_CenterRef_Invalid() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformPoint("C10, C-20", dimensions);
        });
    }

    @Test
    public void testTransformPoint_EndRef_Invalid() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformPoint("R5,B5", dimensions);
        });
    }

    @Test
    public void testTransformPointWithInvalidFormat() {
        Transformer transformer = new Transformer();
        Dimensions dimensions = new Dimensions(10, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            transformer.transformPoint("5-10", dimensions);
        });
    }
}