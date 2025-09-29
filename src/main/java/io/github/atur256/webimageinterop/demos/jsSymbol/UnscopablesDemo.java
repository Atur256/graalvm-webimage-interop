package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class UnscopablesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.unscopables Demo ===");

        JSSymbol sym = JSSymbol.unscopables();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.unscopables: " + sym);
        System.out.println("typeof JSSymbol.unscopables: " + name);
        // Expected:
        // JSSymbol.unscopables: JavaScript<symbol; Symbol(Symbol.unscopables)>
        // typeof JSSymbol.unscopables: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.unscopables.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.unscopables.description: Symbol.unscopables

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.unscopables)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.unscopables", desc);
    }
}