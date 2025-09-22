package tests.jsJson;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import demos.jsJson.*;
import tests.TestUtils;


/**
 * Test runner for JSJson related demo classes.
 * Executes each demo's main method, captures its output, and compares it against expected results.
 */
public class JSJsonTestRunner {

    /**
     * Runs all JSJson demo tests and returns a map of test labels to pass/fail status.
     *
     * @return a map where keys are demo labels and values are true (pass) or false (fail)
     */
    public static Map<String, Boolean> runAll() {
        Map<String, Boolean> results = new LinkedHashMap<>();
        Map<String, String> testCases = createResults();

        for(Map.Entry<String, String> entry : testCases.entrySet()) {
            String label = entry.getKey();
            String expected = entry.getValue();

            // Capture System.out output from the demo class
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(buffer));

            try {
                switch(label) {
                    case "ParseDemo" -> ParseDemo.main(null);
                    case "StringifyDemo" -> StringifyDemo.main(null);
                    case "RawJSONDemo" -> RawJSONDemo.main(null);
                    case "IsRawJSONDemo" -> IsRawJSONDemo.main(null);
                }
            } catch (Throwable t) {
                t.printStackTrace(new PrintStream(buffer));
            } finally {
                // Restore original System.out
                System.setOut(originalOut);
            }

            // Process and compare output
            String actual = buffer.toString().trim();
            String actualWithoutHeading = TestUtils.skipHeading(actual);
            boolean pass = TestUtils.normalize(actualWithoutHeading).equals(TestUtils.normalize(expected));
            results.put(label, pass);

            // Print result summary
            System.out.printf("▶ %s: %s\n", label, pass ? "PASS" : "FAIL");
            if(!pass) {
                System.out.println("Expected:\n" + expected);
                System.out.println("Actual:\n" + actualWithoutHeading + "\n");
            }
        }

        return results;
    }

    /**
     * Creates a map of expected output strings for each demo class.
     * These strings are used to validate the captured output during testing.
     *
     * @return a map of demo labels to expected output
     */
    private static Map<String, String> createResults() {
        Map<String, String> testCases = new LinkedHashMap<>();

        // Expected output for ParseDemo
        testCases.put("ParseDemo", """
                Parsed object: JavaScript<object; [object Object]>
                Name: Alice
                Age: 30
                Parsed with reviver:
                Name: Bob
                Age: 41
                """.trim());

        // Expected output for StringifyDemo
        testCases.put("StringifyDemo", """
                Basic stringify (JSValue): {"name":"Alice","age":30}
                Basic stringify (Java Object): "Bob"
                With replacer (omit age): {"name":"Alice"}
                With replacer + indent:
                {
                "name": "Alice"
                }
                Pretty-print (JSValue):
                {
                "name": "Alice",
                "age": 30
                }
                Pretty-print (Java Object):
                "Bob"
                """.trim());

        // Expected output for RawJSONDemo
        testCases.put("RawJSONDemo", """
                Raw from JSString: "Hello world"
                Is raw JSON (JSValue): true
                Is raw JSON (Object): true
                Raw from String: "Hello world"
                Is raw JSON (JSValue): true
                Is raw JSON (Object): true
                Not raw (JSString): "\\"Hello world\\""
                Is raw JSON (JSValue): false
                Is raw JSON (Object): false
                Plain Java object: {status=ok}
                Is raw JSON (Object): false
                Null object: null
                Is raw JSON (Object): false
                """.trim());

        // Expected output for IsRawJSONDemo
        testCases.put("IsRawJSONDemo", """
                isRawJSON(JSValue) [raw]: true
                isRawJSON(JSValue) [not raw]: false
                isRawJSON(Object) [String]: false
                isRawJSON(Object) [JSValue raw]: true
                isRawJSON(Object) [Java Map]: false
                """.trim());

        return testCases;
    }
}
