package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class MatchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.match Demo ===");

        JSSymbol sym = JSSymbol.match();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.match: " + sym);
        System.out.println("typeof JSSymbol.match: " + name);
        // Expected:
        // JSSymbol.match: JavaScript<symbol; Symbol(Symbol.match)>
        // typeof JSSymbol.match: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.match.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.match.description: Symbol.match

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.match)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.match", desc);
    }
}