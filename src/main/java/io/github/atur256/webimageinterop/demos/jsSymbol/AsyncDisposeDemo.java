package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class AsyncDisposeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.asyncDispose Demo ===");

        JSSymbol sym = JSSymbol.asyncDispose();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.asyncDispose: " + sym);
        System.out.println("typeof JSSymbol.asyncDispose: " + name);
        // Expected:
        // JSSymbol.asyncDispose: JavaScript<symbol; Symbol(nodejs.asyncDispose)>
        // typeof JSSymbol.asyncDispose: JSSymbol

        // Optional: inspect description if supported
        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.asyncDispose.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.asyncDispose.description: nodejs.asyncDispose

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(nodejs.asyncDispose)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("nodejs.asyncDispose", desc);
    }
}