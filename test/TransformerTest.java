import Model.Dimensions;
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
}