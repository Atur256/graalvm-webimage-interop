package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class AsyncIteratorDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.asyncIterator Demo ===");

        JSSymbol sym = JSSymbol.asyncIterator();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.asyncIterator: " + sym);
        System.out.println("typeof JSSymbol.asyncIterator: " + name);
        // Expected:
        // JSSymbol.asyncIterator: JavaScript<symbol; Symbol(Symbol.asyncIterator)>
        // typeof JSSymbol.asyncIterator: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.asyncIterator.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.asyncIterator.description: Symbol.asyncIterator

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.asyncIterator)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.asyncIterator", desc);
    }
}