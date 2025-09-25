package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class UnscopablesDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.unscopables Demo ===");

        JSSymbol sym = JSSymbol.unscopables();

        System.out.println("JSSymbol.unscopables: " + sym);
        System.out.println("typeof JSSymbol.unscopables: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.unscopables: JavaScript<symbol; Symbol(Symbol.unscopables)>
        // typeof JSSymbol.unscopables: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.unscopables.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.unscopables.description: Symbol.unscopables
    }
}
