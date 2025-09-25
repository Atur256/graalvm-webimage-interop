package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class HasInstanceDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.hasInstance Demo ===");

        JSSymbol sym = JSSymbol.hasInstance();

        System.out.println("JSSymbol.hasInstance: " + sym);
        System.out.println("typeof JSSymbol.hasInstance: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.hasInstance: JavaScript<symbol; Symbol(Symbol.hasInstance)>
        // typeof JSSymbol.hasInstance: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.hasInstance.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.hasInstance.description: Symbol.hasInstance
    }
}
