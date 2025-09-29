package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class MatchAllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.matchAll Demo ===");

        JSSymbol sym = JSSymbol.matchAll();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.matchAll: " + sym);
        System.out.println("typeof JSSymbol.matchAll: " + name);
        // Expected:
        // JSSymbol.matchAll: JavaScript<symbol; Symbol(Symbol.matchAll)>
        // typeof JSSymbol.matchAll: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.matchAll.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.matchAll.description: Symbol.matchAll

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.matchAll)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.matchAll", desc);
    }
}