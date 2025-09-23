package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class ForDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.for Demo ===");

        Object sym1 = JSSymbol.forKey("shared");
        Object sym2 = JSSymbol.forKey("shared");
        Object sym3 = JSSymbol.forKey("unique");

        System.out.println("Symbol.for(\"shared\") equals Symbol.for(\"shared\"): " + (sym1.equals(sym2)));
        System.out.println("Symbol.for(\"shared\") equals Symbol.for(\"unique\"): " + (sym1.equals(sym3)));
        System.out.println("typeof Symbol.for(\"shared\"): " + sym1.getClass().getSimpleName());
        // Expected:
        // Symbol.for("shared") equals Symbol.for("shared"): true
        // Symbol.for("shared") equals Symbol.for("unique"): false
        // typeof Symbol.for("shared"): JSSymbol
    }
}
