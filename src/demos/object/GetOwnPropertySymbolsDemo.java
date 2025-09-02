package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class GetOwnPropertySymbolsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertySymbols Demo ===");

        JSObject obj = JSObject.create();
        System.out.println("Property symbols: " + Object.getOwnPropertySymbols(obj));
    }
}
