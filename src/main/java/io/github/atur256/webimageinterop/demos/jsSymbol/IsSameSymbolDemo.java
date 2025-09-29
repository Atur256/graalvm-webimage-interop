package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.*;


public class IsSameSymbolDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.for Identity Demo ===");

        boolean same = JSSymbol.isSameSymbol("alpha", "alpha");
        boolean different = JSSymbol.isSameSymbol("alpha", "beta");

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