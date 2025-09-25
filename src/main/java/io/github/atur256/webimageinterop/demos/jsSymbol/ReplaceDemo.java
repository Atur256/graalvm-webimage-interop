package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class ReplaceDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.replace Demo ===");

        JSSymbol sym = JSSymbol.replace();

        System.out.println("JSSymbol.replace: " + sym);
        System.out.println("typeof JSSymbol.replace: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.replace: JavaScript<symbol; Symbol(Symbol.replace)>
        // typeof JSSymbol.replace: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.replace.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.replace.description: Symbol.replace
    }
}
