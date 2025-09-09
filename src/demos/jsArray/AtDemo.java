package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class AtDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.at Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b"), JSString.of("c")});
        System.out.println("Element at index -1: " + arr.at(-1).as(String.class)); // Expected: "c"

        int[] scores = {10, 20, 30};
        JSArray scoreArr = JSArray.from(scores);
        System.out.println("int[] First: " + scoreArr.at(0, Integer.class)); // Expected: 10
    }
}
