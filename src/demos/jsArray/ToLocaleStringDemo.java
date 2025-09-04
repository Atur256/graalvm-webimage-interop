package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toLocaleString Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSNumber.of(123456.789), JSNumber.of(987654.321)
        });

        String localized = arr.toLocaleString();
        System.out.println("Localized string: " + localized);
        // Expected: Locale-formatted numbers, e.g. "123,456.789,987,654.321"
    }
}
