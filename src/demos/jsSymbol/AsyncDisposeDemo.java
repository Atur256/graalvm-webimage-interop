package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class AsyncDisposeDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.asyncDispose Demo ===");

        JSSymbol sym = JSSymbol.asyncDispose();

        System.out.println("JSSymbol.asyncDispose: " + sym);
        System.out.println("typeof JSSymbol.asyncDispose: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.asyncDispose: JavaScript<symbol; Symbol(nodejs.asyncDispose)>
        // typeof JSSymbol.asyncDispose: JSSymbol

        // Optional: inspect description if supported
        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.asyncDispose.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.asyncDispose.description: nodejs.asyncDispose
    }
}
