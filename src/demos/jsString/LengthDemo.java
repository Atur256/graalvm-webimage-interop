package demos.jsString;

import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.length Demo ===");

        JSString text = JSString.of("Life, the universe and everything. Answer:");

        System.out.println(JSValue.checkedCoerce(text, String.class) + text.length());
        // Expected: Life, the universe and everything. Answer:: 42
    }
}
