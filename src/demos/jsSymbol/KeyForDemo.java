package demos.jsSymbol;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSSymbol;
import org.graalvm.webimage.api.JSValue;


public class KeyForDemo {


    public static void main(String[] args) {
        System.out.println("=== Symbol.keyFor Demo ===");

        Object shared1 = JSSymbol.forKey("alpha");
        Object shared2 = JSSymbol.forKey("beta");

        System.out.println("Symbol.keyFor(Symbol.for(\"alpha\")): " + JSValue.checkedCoerce(JSSymbol.keyFor(shared1), String.class));
        System.out.println("Symbol.keyFor(Symbol.for(\"beta\")): " + JSValue.checkedCoerce(JSSymbol.keyFor(shared2), String.class));
        // Expected:
        // Symbol.keyFor(Symbol.for("alpha")): alpha
        // Symbol.keyFor(Symbol.for("beta")): beta

        // Non-registry symbol: Symbol("gamma")
        Object local = createLocalSymbol("gamma");
        System.out.println("Symbol.keyFor(Symbol(\"gamma\")): " + JSSymbol.keyFor(local));
        // Expected:
        // Symbol.keyFor(Symbol("gamma")): JavaScript<undefined; undefined>
    }

    @JS.Coerce
    @JS(value = "return Symbol(desc);")
    public static native Object createLocalSymbol(String desc);
}
