import Service.TextFileParser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextFileParserTest {
    @Test
    public void testGetTextFileFromURL() {
        TextFileParser parser = new TextFileParser();
        try {
            List<String> expected = List.of("100x100", "10,10", "R-10,10", "R-10,B-10", "10,B-10");
            InputStream rawLines = new FileInputStream("test/data/input.txt");
            List<String> lines = parser.getLines(new Scanner(rawLines));

            assertEquals(expected, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetLinesWithValidInput() {
        TextFileParser parser = new TextFileParser();
        String input = "100x100\n10,10\nR-10,10\nR-10,B-10\n10,B-10";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        List<String> lines = parser.getLines(new Scanner(stream));
        assertEquals(List.of("100x100", "10,10", "R-10,10", "R-10,B-10", "10,B-10"), lines);
    }

    @Test
    public void testGetLinesWithInvalidInput() {
        TextFileParser parser = new TextFileParser();
        String input = "100x100\n10,10\nR-10,10\nR-10,B-10\n10,B-10\ninvalid";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        assertThrows(IllegalArgumentException.class, () -> parser.getLines(new Scanner(stream)));
    }

    @Test
    public void testGetLinesWithComments() {
        TextFileParser parser = new TextFileParser();
        String input = "100x100\n# This is a comment\n10,10\nR-10,10\nR-10,B-10\n10,B-10";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        List<String> lines = parser.getLines(new Scanner(stream));
        assertEquals(List.of("100x100", "10,10", "R-10,10", "R-10,B-10", "10,B-10"), lines);
    }
}