package demos.jsEval;

import builtin.JSEval;
import org.graalvm.webimage.api.JSValue;


public class EvalDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSEval.eval Demo ===");

        int result1 = JSEval.eval("2 + 2", Integer.class);
        System.out.println("eval(\"2 + 2\"): " + result1);
        // Expected: eval("2 + 2"): 4

        int result2 = JSEval.eval("Math.max(10, 20)", Integer.class);
        System.out.println("eval(\"Math.max(10, 20)\"): " + result2);
        // Expected: eval("Math.max(10, 20)"): 20

        String result3 = JSEval.eval("'Hello ' + 'World'",String.class);
        System.out.println("eval(\"'Hello ' + 'World'\"): " + result3);
        // Expected: eval("'Hello ' + 'World'"): Hello World

        String result4 = JSEval.eval("typeof 42",String.class);
        System.out.println("eval(\"typeof 42\"): " + result4);
        // Expected: eval("typeof 42"): number

        int result5= JSEval.eval("let x = 5; x * 2", Integer.class);
        System.out.println("eval(\"let x = 5; x * 2\"): " + result5);
        // Expected: eval("let x = 5; x * 2"): 10

        JSValue result6 = JSEval.eval("[1, 2, 3].map(n => n * 2)", JSValue.class);
        System.out.println(result6.getClass());
        System.out.println("eval(\"[1, 2, 3].map(n => n * 2)\"): " + result6);
        // Expected: eval("[1, 2, 3].map(n => n * 2)"): JavaScript<object; 2,4,6>
    }
}
