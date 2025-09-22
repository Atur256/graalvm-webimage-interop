package tests.jsNumber;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import demos.jsNumber.*;
import tests.TestUtils;


/**
 * Test runner for JSNumber-related demo classes.
 * Executes each demo's main method, captures its output, and compares it against expected results.
 */
public class JSNumberTestRunner {

    /**
     * Runs all JSNumber demo tests and returns a map of test labels to pass/fail status.
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
                    case "IsFiniteDemo" -> IsFiniteDemo.main(null);
                    case "IsIntegerDemo" -> IsIntegerDemo.main(null);
                    case "IsNaNDemo" -> IsNaNDemo.main(null);
                    case "IsSafeIntegerDemo" -> IsSafeIntegerDemo.main(null);
                    case "ParseFloatDemo" -> ParseFloatDemo.main(null);
                    case "ParseIntDemo" -> ParseIntDemo.main(null);
                    case "NumberConstantsDemo" -> NumberConstantsDemo.main(null);
                    case "ToExponentialDemo" -> ToExponentialDemo.main(null);
                    case "ToFixedDemo" -> ToFixedDemo.main(null);
                    case "ToLocaleStringDemo" -> ToLocaleStringDemo.main(null);
                    case "ToPrecision" -> ToPrecision.main(null);
                    case "ToStringDemo" -> ToStringDemo.main(null);
                    case "ValueOfDemo" -> ValueOfDemo.main(null);
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
                System.out.println("Actual:\n\n" + actualWithoutHeading + "\n");
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

        // Expected output for IsFiniteDemo
        testCases.put("IsFiniteDemo", """
                JSNumber 42 isFinite: true
                JSNumber Infinity isFinite: false
                JSNumber NaN isFinite: false
                Number 123 isFinite: true
                Number 1.23 isFinite: true
                Number -Infinity isFinite: false
                Number NaN isFinite: false
                """.trim());

        // Expected output for IsIntegerDemo
        testCases.put("IsIntegerDemo", """
                JSNumber 42 isInteger: true
                JSNumber 3.14 isInteger: false
                JSNumber NaN isInteger: false
                JSNumber Infinity isInteger: false
                Number 100 isInteger: true
                Number 2.718 isInteger: false
                Number NaN isInteger: false
                Number -Infinity isInteger: false
                """.trim());

        // Expected output for IsNaNDemo
        testCases.put("IsNaNDemo", """
                JSValue 42 isNaN: false
                JSValue NaN isNaN: true
                JSValue Infinity isNaN: false
                Number 123 isNaN: false
                Number 1.23 isNaN: false
                Number NaN isNaN: true
                Number -Infinity isNaN: false
                """.trim());

        // Expected output for IsSafeIntegerDemo
        testCases.put("IsSafeIntegerDemo", """
                JSValue 9007199254740991 isSafeInteger: true
                JSValue 9007199254740992 isSafeInteger: false
                JSValue 3.14 isSafeInteger: false
                JSValue NaN isSafeInteger: false
                Number 42 isSafeInteger: true
                Number 1e100 isSafeInteger: false
                Number 2.718 isSafeInteger: false
                Number NaN isSafeInteger: false
                """.trim());

        // Expected output for ParseFloatDemo
        testCases.put("ParseFloatDemo", """
                parseFloat(42):42.0
                parseFloat(3.1415): 3.1415
                parseFloat("123.456"): 123.456
                parseFloat("3.14abc"): 3.14
                parseFloat("abc"): NaN
                """.trim());

        // Expected output for ParseIntDemo
        testCases.put("ParseIntDemo", """
                parseInt(42.9): 42
                parseInt(-3.99): -3
                parseInt("123"): 123
                parseInt("123.456"): 123
                parseInt("abc"): 0
                parseInt("1010", 2): 10
                parseInt("FF", 16): 255
                parseInt("77", 8): 63
                """.trim());

        // Expected output for NumberConstantsDemo
        testCases.put("NumberConstantsDemo", """
                EPSILON: double: 2.220446e-16 | int: 0
                MAX_SAFE_INTEGER: double: 9.007199e+15 | int: 2147483647
                MAX_VALUE: double: 1.797693e+308 | int: 2147483647
                MIN_SAFE_INTEGER: double: -9.007199e+15 | int: -2147483648
                MIN_VALUE: double: 4.900000e-324 | int: 0
                NaN: double: NaN | int: 0
                NEGATIVE_INFINITY: double: -Infinity | int: -2147483648
                POSITIVE_INFINITY: double: Infinity | int: 2147483647
                """.trim());

        // Expected output for ToExponentialDemo
        testCases.put("ToExponentialDemo", """
                Default exponential:
                0.00001234: 1.234e-5
                123456789: 1.23456789e+8
                π: 3.14159265358979e+0
                Exponential with precision:
                0.00001234: 1.23e-5
                123456789: 1.2346e+8
                π: 3.141593e+0
                """.trim());

        // Expected output for ToFixedDemo
        testCases.put("ToFixedDemo", """
                Default toFixed:
                3.1415926535: 3
                123.456: 123
                0.00001234: 0
                toFixed with precision:
                3.1415926535: 3.14
                123.456: 123.4560
                0.00001234: 0.00001234
                """.trim());

        // Expected output for ToLocaleStringDemo
        testCases.put("ToLocaleStringDemo", """
                Default locale: 1,234,567.89
                German (Austria): 1 234 567,89
                US English: 1,234,567.89
                Currency (de-AT): € 1.234.567,89
                Fixed fraction (en-US): 1,234,567.8900
                """.trim());

        // Expected output for toPrecision
        testCases.put("ToPrecision", """
                Default precision:
                123.456789: 123.456789
                0.0000123456789: 0.0000123456789
                987654321.123: 987654321.123
                With specified precision:
                123.456789: 123.5
                0.0000123456789: 0.0000123
                987654321.123: 9.87654e+8
                """.trim());

        // Expected output for ToStringDemo
        testCases.put("ToStringDemo", """
                255: 255
                3.14159: 3.14159
                -42: -42
                Radix conversion:
                255 in binary: 11111111
                255 in hex: ff
                255 in octal: 377
                -42 in base 5: -132
                """.trim());

        // Expected output for ValueOfDemo
        testCases.put("ValueOfDemo", """
                JSNumber 42 valueOf: 42.0
                JSNumber π valueOf: 3.14159
                JSNumber NaN valueOf: NaN
                """.trim());

        return testCases;
    }
}
