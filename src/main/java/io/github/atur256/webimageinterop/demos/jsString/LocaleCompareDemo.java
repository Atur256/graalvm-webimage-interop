package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class LocaleCompareDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.localeCompare Demo ===");

        JSString a = JSString.of("a");
        JSString A = JSString.of("A");
        JSString a2 = JSString.of("ä");
        JSString ae = JSString.of("ae");

        int result1 = A.localeCompare("a");
        int result2 = a.localeCompare("A");
        int result3 = A.localeCompare("A");
        System.out.println("\"A\" vs \"a\": " + result1);
        System.out.println("\"a\" vs \"A\": " + result2);
        System.out.println("\"A\" vs \"A\": " + result3);
        // Expected:
        // "A" vs "a": 1
        // "a" vs "A": -1
        // "A" vs "A": 0

        int result4 = a2.localeCompare("ae", "de");
        System.out.println("\"ä\" vs \"ae\" (de): " + result4);
        // Expected: "ä" vs "ae" (de): -1

        Map<String, Object> caseSensitive = Map.of("sensitivity", "case");
        int result5 = a.localeCompare("A", "en", caseSensitive);
        int result6 = A.localeCompare("a", "en", caseSensitive);
        System.out.println("\"a\" vs \"A\" (en, case): " + result5);
        System.out.println("\"A\" vs \"a\" (en, case): " + result6);
        // Expected:
        // "a" vs "A" (en, case): -1
        // "A" vs "a" (en, case): 1

        int result7 = a.localeCompare(A);
        System.out.println("\"a\" vs JSString(\"A\"): " + result7);
        // Expected: "a" vs JSString("A"): -1

        int result8 = a2.localeCompare(ae, JSString.of("sv"));
        System.out.println("\"ä\" vs JSString(\"ae\") (sv): " + result8);
        // Expected: "ä" vs JSString("ae") (sv): -1

        Map<String, Object> accentSensitive = Map.of("sensitivity", "accent");
        int result9 = a2.localeCompare("a", "en", accentSensitive);
        int result10 = a.localeCompare(a2, JSString.of("en"), accentSensitive);
        int result11 = a2.localeCompare("ä", "en", accentSensitive);
        System.out.println("\"ä\" vs JSString(\"a\") (en, accent): " + result9);
        System.out.println("\"a\" vs JSString(\"ä\") (en, accent): " + result10);
        System.out.println("\"ä\" vs JSString(\"ä\") (en, accent): " + result11);
        // Expected:
        // "ä" vs JSString("a") (en, accent): -1
        // "a" vs JSString("ä") (en, accent): 1
        // "ä" vs JSString("ä") (en, accent): 0

        // Assert values
        assertEquals(1, result1);
        assertEquals(-1, result2);
        assertEquals(0, result3);
        assertEquals(-1, result4);
        assertEquals(-1, result5);
        assertEquals(1, result6);
        assertEquals(-1, result7);
        assertEquals(-1, result8);
        assertEquals(-1, result9);
        assertEquals(1, result10);
        assertEquals(0, result11);
    }
}