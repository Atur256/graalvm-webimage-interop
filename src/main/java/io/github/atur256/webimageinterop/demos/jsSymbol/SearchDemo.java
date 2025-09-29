package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class SearchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.search Demo ===");

        JSSymbol sym = JSSymbol.search();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.search: " + sym);
        System.out.println("typeof JSSymbol.search: " + name);
        // Expected:
        // JSSymbol.search: JavaScript<symbol; Symbol(Symbol.search)>
        // typeof JSSymbol.search: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.search.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.search.description: Symbol.search

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.search)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.search", desc);
    }
}