package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileParser {
    public List<String> getLines(Scanner scanner) {
        List<String> inputLines = getTextFileWithoutComments(scanner);
        List<String> outputLines = new ArrayList<>();

        for (String inputLine : inputLines) {
            if (inputLine.isEmpty()) {
                continue;
            }

            if (outputLines.isEmpty()) {
                if (inputLine.matches("^\\d+x\\d+$")) {
                    outputLines.add(inputLine);
                    continue;
                } else {
                    this.throwExceptionIfInvalidCharacter(inputLine, inputLines.indexOf(inputLine));
                }
            }

            if (inputLine.matches("^[LCR]?[-+]?[0-9]*.?[0-9]+,[LCB]?[-+]?[0-9]*.?[0-9]+$")) {
                outputLines.add(inputLine);
            } else {
                this.throwExceptionIfInvalidCharacter(inputLine, inputLines.indexOf(inputLine));
            }
        }

        return outputLines;
    }

    private List<String> getTextFileWithoutComments(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isBlank()) {
                lines.add("");

                continue;
            }

            if (line.charAt(0) == '#') {
                lines.add("");

                continue;
            }

            if (line.contains("#")) {
                line = line.substring(0, line.indexOf("#"));
                line = line.trim();
                lines.add(line);

                continue;
            }

            line = line.trim();
            lines.add(line);
        }

        return lines;
    }

    private void throwExceptionIfInvalidCharacter(String line, int lineIndex) {
        throw new IllegalArgumentException("Invalid character at line: " + lineIndex + " - " + line);
    }
}