package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.*;


public class IsSameSymbolDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.for Identity Demo ===");

        JSSymbol sym1 = JSSymbol.forKey("alpha");
        JSSymbol sym2 = JSSymbol.forKey("alpha");
        JSSymbol sym3 = JSSymbol.forKey("beta");

        boolean same = JSSymbol.isSameSymbol(sym1, sym2);
        boolean different = JSSymbol.isSameSymbol(sym1, sym2);

        System.out.println("JSSymbol.for('alpha') === JSSymbol.for('alpha'): " + same);
        System.out.println("JSSymbol.for('alpha') === JSSymbol.for('beta'): " + different);
        // Expected:
        // JSSymbol.for('alpha') === JSSymbol.for('alpha'): true
        // JSSymbol.for('alpha') === JSSymbol.for('beta'): false

        // Assert values
        assertTrue(same);
        assertFalse(different);
    }
}