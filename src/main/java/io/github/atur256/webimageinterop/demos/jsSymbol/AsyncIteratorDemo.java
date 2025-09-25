package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class AsyncIteratorDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.asyncIterator Demo ===");

        JSSymbol sym = JSSymbol.asyncIterator();

        System.out.println("JSSymbol.asyncIterator: " + sym);
        System.out.println("typeof JSSymbol.asyncIterator: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.asyncIterator: Symbol(Symbol.asyncIterator)
        // typeof JSSymbol.asyncIterator: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.asyncIterator.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.asyncIterator.description: Symbol.asyncIterator
    }
}
