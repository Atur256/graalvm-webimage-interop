package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for processing and comparing console output from demo classes.
 * Provides normalization, optional heading removal, and empty line filtering
 * to support consistent test validation.
 */
public class TestUtils {

    /**
     * Normalizes a string by converting Windows-style line endings to Unix-style
     * and trimming leading/trailing whitespace.
     *
     * @param s the input string to normalize
     * @return the normalized string with unified line endings and trimmed edges
     */
    public static String normalize(String s) {
        // Replace CRLF with LF and trim whitespace
        return s.replace("\r\n", "\n").trim();
    }

    /**
     * Removes the heading line from a multi-line string if it exists,
     * and filters out any empty lines from the remaining output.
     * A heading is defined as a line starting with "===".
     *
     * @param s the input string containing console output
     * @return the cleaned string with heading removed (if present) and empty lines filtered
     */
    public static String skipHeading(String s) {
        // Normalize line endings and split into lines
        String[] lines = s.replace("\r\n", "\n").split("\n", -1);

        // Determine starting index (skip heading if present)
        int start = (lines.length > 0 && lines[0].trim().startsWith("===")) ? 1 : 0;

        // Filter out empty lines and reassemble
        List<String> filtered = new ArrayList<>();
        for (int i = start; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!line.isEmpty()) {
                filtered.add(line);
            }
        }

        return String.join("\n", filtered);
    }
}
