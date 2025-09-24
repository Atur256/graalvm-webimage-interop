package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class DisposeDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.dispose Demo ===");

        JSSymbol sym = JSSymbol.dispose();

        System.out.println("JSSymbol.dispose: " + sym);
        System.out.println("typeof JSSymbol.dispose: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.dispose: JavaScript<symbol; Symbol(nodejs.dispose)>
        // typeof JSSymbol.dispose: JSSymbol

        String  desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.dispose.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.dispose.description: nodejs.dispose
    }
}
