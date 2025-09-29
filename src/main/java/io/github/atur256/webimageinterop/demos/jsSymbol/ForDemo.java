package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.*;


public class ForDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.for Demo ===");

        JSSymbol sym1 = JSSymbol.forKey("shared");
        JSSymbol sym2 = JSSymbol.forKey("shared");
        JSSymbol sym3 = JSSymbol.forKey("unique");

        boolean result1 = (sym1.equals(sym2));
        boolean result2 = (sym1.equals(sym3));
        String name = sym1.getClass().getSimpleName();
        System.out.println("JSSymbol.for(\"shared\") equals Symbol.for(\"shared\"): " + result1);
        System.out.println("JSSymbol.for(\"shared\") equals Symbol.for(\"unique\"): " + result2);
        System.out.println("typeof Symbol.for(\"shared\"): " + name);
        // Expected:
        // JSSymbol.for("shared") equals Symbol.for("shared"): true
        // JSSymbol.for("shared") equals Symbol.for("unique"): false
        // typeof Symbol.for("shared"): JSSymbol

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
        assertEquals("JSSymbol", name);
    }
}