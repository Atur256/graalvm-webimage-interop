package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class HasInstanceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.hasInstance Demo ===");

        JSSymbol sym = JSSymbol.hasInstance();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.hasInstance: " + sym);
        System.out.println("typeof JSSymbol.hasInstance: " + name);
        // Expected:
        // JSSymbol.hasInstance: JavaScript<symbol; Symbol(Symbol.hasInstance)>
        // typeof JSSymbol.hasInstance: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.hasInstance.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.hasInstance.description: Symbol.hasInstance

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.hasInstance)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.hasInstance", desc);
    }
}