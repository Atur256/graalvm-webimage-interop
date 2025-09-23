package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class AsyncDisposeDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.asyncDispose Demo ===");

        Object sym = JSSymbol.asyncDispose();

        System.out.println("Symbol.asyncDispose: " + sym);
        System.out.println("typeof Symbol.asyncDispose: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.asyncDispose: JavaScript<symbol; Symbol(nodejs.asyncDispose)>
        // typeof Symbol.asyncDispose: JSSymbol

        // Optional: inspect description if supported
        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.asyncDispose.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.asyncDispose.description: nodejs.asyncDispose
    }
}
