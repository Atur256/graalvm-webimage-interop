package demos.jsRegExp;

import builtin.JSRegExp;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.toString Demo ===");

        JSRegExp regex = JSRegExp.of("abc", "g");
        System.out.println("Regex string: " + regex.toString());
        // Expected Output: Regex string: /abc/g
    }
}
