package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class ToPrimitiveDemo {


    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.toPrimitive Demo ===");

        JSSymbol sym = JSSymbol.toPrimitive();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.toPrimitive: " + sym);
        System.out.println("typeof JSSymbol.toPrimitive: " + name);
        // Expected:
        // JSSymbol.toPrimitive: JavaScript<symbol; Symbol(Symbol.toPrimitive)>
        // typeof JSSymbol.toPrimitive: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.toPrimitive.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.toPrimitive.description: Symbol.toPrimitive

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.toPrimitive)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.toPrimitive", desc);
    }
}