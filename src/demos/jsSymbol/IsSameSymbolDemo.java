package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class IsSameSymbolDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.for Identity Demo ===");

        boolean same = JSSymbol.isSameSymbol("alpha", "alpha");
        boolean different = JSSymbol.isSameSymbol("alpha", "beta");

        System.out.println("JSSymbol.for('alpha') === JSSymbol.for('alpha'): " + same);
        System.out.println("JSSymbol.for('alpha') === JSSymbol.for('beta'): " + different);
        // Expected:
        // JSSymbol.for('alpha') === JSSymbol.for('alpha'): true
        // JSSymbol.for('alpha') === JSSymbol.for('beta'): false
    }
}
