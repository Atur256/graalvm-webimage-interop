package io.github.atur256.webimageinterop.demos.jsRegExp;

import io.github.atur256.webimageinterop.builtin.JSRegExp;


public class ExecDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.exec Demo ===");

        JSRegExp regex = JSRegExp.of("a(b)c", "");
        var result = regex.exec("abc");
        System.out.println("Exec result: " + result);
        // Expected: Exec result: JavaScript<object; abc,b>
    }
}
