package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class DisposeDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.dispose Demo ===");

        Object sym = JSSymbol.dispose();

        System.out.println("Symbol.dispose: " + sym);
        System.out.println("typeof Symbol.dispose: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.dispose: JavaScript<symbol; Symbol(nodejs.dispose)>
        // typeof Symbol.dispose: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.dispose.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.dispose.description: nodejs.dispose
    }
}
