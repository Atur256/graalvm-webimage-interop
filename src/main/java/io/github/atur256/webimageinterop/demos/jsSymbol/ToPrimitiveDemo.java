package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class ToPrimitiveDemo {


    public static void main(String[] args) {
        System.out.println("=== JSSymbol.toPrimitive Demo ===");

        JSSymbol sym = JSSymbol.toPrimitive();

        System.out.println("JSSymbol.toPrimitive: " + sym);
        System.out.println("typeof JSSymbol.toPrimitive: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.toPrimitive: JavaScript<symbol; Symbol(Symbol.toPrimitive)>
        // typeof JSSymbol.toPrimitive: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.toPrimitive.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.toPrimitive.description: Symbol.toPrimitive
    }
}
