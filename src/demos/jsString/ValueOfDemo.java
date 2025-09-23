package demos.jsString;

import org.graalvm.webimage.api.JSString;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.valueOfDemo ===");

        JSString text = JSString.of("To be, or not to be");

        System.out.println("valueOf(): " + text.valueOf().as(String.class));
        // Expected: valueOf(): To be, or not to be
    }
}
