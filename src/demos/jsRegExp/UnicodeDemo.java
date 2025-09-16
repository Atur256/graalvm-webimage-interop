package demos.jsRegExp;

import builtin.JSRegExp;


public class UnicodeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.unicode Demo ===");

        JSRegExp regex = JSRegExp.of("\\u{1F600}", "u");
        System.out.println("Unicode? " + regex.unicode);
        // Expected: Unicode? true
    }
}
