package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

public class ConcatDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSArray.concat Demo ===");

        JSArray a1 = JSArray.of(new JSValue[]{JSNumber.of(1), JSNumber.of(2)}); // TODO: 1,2,3,4,5
        JSArray a2 = JSArray.of(new JSValue[]{JSNumber.of(3), JSNumber.of(4)});
        JSArray a3 = JSArray.of(new JSValue[]{JSNumber.of(5)});

        JSArray result = a1.concat(new JSArray[]{a2, a3});
        System.out.println("Concatenated: " + result.toStringJS()); // Expected: [1, 2, 3, 4, 5]
    }
}
