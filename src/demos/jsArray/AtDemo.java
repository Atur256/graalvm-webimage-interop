package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.at Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b"), JSString.of("c")});
        System.out.println("Element at index -1: " + arr.at(-1, String.class));
        // Expected: Element at index -1: "c"

        JSArray scoreArr = JSArray.from(10, 20, 30);
        System.out.println("Element at index 0: " + scoreArr.at(0, Integer.class));
        // Expected: Element at index 0: 10
    }
}
