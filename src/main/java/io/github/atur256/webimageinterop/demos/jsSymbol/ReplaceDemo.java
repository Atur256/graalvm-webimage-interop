package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class ReplaceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.replace Demo ===");

        JSSymbol sym = JSSymbol.replace();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.replace: " + sym);
        System.out.println("typeof JSSymbol.replace: " + name);
        // Expected:
        // JSSymbol.replace: JavaScript<symbol; Symbol(Symbol.replace)>
        // typeof JSSymbol.replace: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.replace.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.replace.description: Symbol.replace

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.replace)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.replace", desc);
    }
}