package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class SplitDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.split Demo ===");

        JSSymbol sym = JSSymbol.split();

        System.out.println("JSSymbol.split: " + sym);
        System.out.println("typeof JSSymbol.split: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.split: JavaScript<symbol; Symbol(Symbol.split)>
        // typeof JSSymbol.split: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.split.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.split.description: Symbol.split
    }
}
