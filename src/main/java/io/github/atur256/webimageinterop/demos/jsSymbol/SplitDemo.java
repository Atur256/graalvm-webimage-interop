package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class SplitDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.split Demo ===");

        JSSymbol sym = JSSymbol.split();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.split: " + sym);
        System.out.println("typeof JSSymbol.split: " + name);
        // Expected:
        // JSSymbol.split: JavaScript<symbol; Symbol(Symbol.split)>
        // typeof JSSymbol.split: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.split.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.split.description: Symbol.split

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.split)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.split", desc);
    }
}