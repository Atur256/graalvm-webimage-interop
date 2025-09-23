package demos.jsString;

import org.graalvm.webimage.api.JSString;

import java.util.Map;


public class LocaleCompareDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.localeCompare Demo ===");

        JSString a = JSString.of("a");
        JSString A = JSString.of("A");
        JSString a2 = JSString.of("ä");
        JSString ae = JSString.of("ae");

        System.out.println("\"A\" vs \"a\": " + A.localeCompare("a"));
        System.out.println("\"a\" vs \"A\": " + a.localeCompare("A"));
        System.out.println("\"A\" vs \"A\": " + A.localeCompare("A"));
        // Expected:
        // "A" vs "a": 1
        // "a" vs "A": -1
        // "A" vs "A": 0

        System.out.println("\"ä\" vs \"ae\" (de): " + a2.localeCompare("ae", "de"));
        // Expected: "ä" vs "ae" (de): -1

        Map<String, Object> caseSensitive = Map.of("sensitivity", "case");
        System.out.println("\"a\" vs \"A\" (en, case): " + a.localeCompare("A", "en", caseSensitive));
        System.out.println("\"A\" vs \"a\" (en, case): " + A.localeCompare("a", "en", caseSensitive));
        // Expected:
        // "a" vs "A" (en, case): -1
        // "A" vs "a" (en, case): 1

        System.out.println("\"a\" vs JSString(\"A\"): " + a.localeCompare(A));
        // Expected: "a" vs JSString("A"): -1

        System.out.println("\"ä\" vs JSString(\"ae\") (sv): " + a2.localeCompare(ae, JSString.of("sv")));
        // Expected: "ä" vs JSString("ae") (sv): -1

        Map<String, Object> accentSensitive = Map.of("sensitivity", "accent");
        System.out.println("\"ä\" vs JSString(\"a\") (en, accent): " + a2.localeCompare("a", "en", accentSensitive));
        System.out.println("\"a\" vs JSString(\"ä\") (en, accent): " + a.localeCompare(a2, JSString.of("en"), accentSensitive));
        System.out.println("\"ä\" vs JSString(\"ä\") (en, accent): " + a2.localeCompare("ä", "en", accentSensitive));
        // Expected:
        // "ä" vs JSString("a") (en, accent): -1
        // "a" vs JSString("ä") (en, accent): 1
        // "ä" vs JSString("ä") (en, accent): o
    }
}
