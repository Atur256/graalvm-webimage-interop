package demos.number;

import builtin.Number;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;


public class IsNaNDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Number.isNaN Demo ===");

        System.out.println("isNaN(JSNumber.of(1234)): " + Number.isNaN(JSNumber.of(1234)));
        // Expected: false (1234 is a valid number)

        System.out.println("isNaN(JSString.of(\"1234\")): " + Number.isNaN(JSString.of("1234")));
        // Expected: false ("1234" can be coerced to a number)

        System.out.println("isNaN(JSString.of(\"abc\")): " + Number.isNaN(JSString.of("abc")));
        // Expected: true ("abc" cannot be coerced to a number)

        System.out.println("isNaN(JSNumber.of(Double.NaN)): " + Number.isNaN(JSNumber.of(Double.NaN)));
        // Expected: true (NaN is NaN)
    }
}
