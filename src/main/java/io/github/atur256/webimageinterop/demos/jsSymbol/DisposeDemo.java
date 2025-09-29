package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class DisposeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.dispose Demo ===");

        JSSymbol sym = JSSymbol.dispose();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.dispose: " + sym);
        System.out.println("typeof JSSymbol.dispose: " + name);
        // Expected:
        // JSSymbol.dispose: JavaScript<symbol; Symbol(nodejs.dispose)>
        // typeof JSSymbol.dispose: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.dispose.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.dispose.description: nodejs.dispose

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(nodejs.dispose)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("nodejs.dispose", desc);
    }
}