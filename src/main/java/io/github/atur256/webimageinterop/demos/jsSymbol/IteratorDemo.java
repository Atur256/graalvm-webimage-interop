package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class IteratorDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.iterator Demo ===");

        JSSymbol sym = JSSymbol.iterator();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.iterator: " + sym);
        System.out.println("typeof JSSymbol.iterator: " + name);
        // Expected:
        // JSSymbol.iterator: JavaScript<symbol; Symbol(Symbol.iterator)>
        // typeof JSSymbol.iterator: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.iterator.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.iterator.description: Symbol.iterator

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.iterator)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.iterator", desc);
    }
}