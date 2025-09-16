package demos.object;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSSymbol;


public class GetOwnPropertySymbolsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getOwnPropertySymbols Demo ===");

        JSObject obj = JSObject.create();

        JSSymbol a = JSSymbol.of("a");
        JSSymbol b = JSSymbol.of("b");

        obj.set(a, "localSymbol");
        obj.set(b, "globalSymbol");

//        JSSymbol symbols = Object.getOwnPropertySymbols(obj);
//
//        System.out.println("Property symbols: " + symbols);
    }
}
