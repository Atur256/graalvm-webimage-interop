package demos.jsSymbol;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSSymbol;
import org.graalvm.webimage.api.JSValue;


public class KeyForDemo {


    public static void main(String[] args) {
        System.out.println("=== JSSymbol.keyFor Demo ===");

        JSSymbol shared1 = JSSymbol.forKey("alpha");
        JSSymbol shared2 = JSSymbol.forKey("beta");

        System.out.println("JSSymbol.keyFor(Symbol.for(\"alpha\")): " + JSValue.checkedCoerce(JSSymbol.keyFor(shared1), String.class));
        System.out.println("JSSymbol.keyFor(Symbol.for(\"beta\")): " + JSValue.checkedCoerce(JSSymbol.keyFor(shared2), String.class));
        // Expected:
        // JSSymbol.keyFor(Symbol.for("alpha")): alpha
        // JSSymbol.keyFor(Symbol.for("beta")): beta

        // Non-registry symbol: Symbol("gamma")
        JSSymbol local = createLocalSymbol("gamma");

        System.out.println("JSSymbol.keyFor(Symbol(\"gamma\")): " + JSSymbol.keyFor(local));
        // Expected:
        // JSSymbol.keyFor(Symbol("gamma")): JavaScript<undefined; undefined>
    }

    @JS.Coerce
    @JS(value = "return Symbol(desc);")
    public static native JSSymbol createLocalSymbol(String desc);
}