package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class ToStringTagDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Symbol.toStringTag Demo ===");

        JSSymbol sym = JSSymbol.toStringTag();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.toStringTag: " + sym);
        System.out.println("typeof JSSymbol.toStringTag: " + name);
        // Expected:
        // JSSymbol.toStringTag: JavaScript<symbol; Symbol(Symbol.toStringTag)>
        // typeof JSSymbol.toStringTag: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.toStringTag.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.toStringTag.description: Symbol.toStringTag

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.toStringTag)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.toStringTag", desc);
    }
}