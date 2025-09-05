package demos.jsEval;

import builtin.JSEval;


public class EvalDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSEval.eval Demo ===");

        System.out.println("eval(\"2 + 2\"): " + JSEval.eval("2 + 2"));
        // Expected: 4

        System.out.println("eval(\"Math.max(10, 20)\"): " + JSEval.eval("Math.max(10, 20)"));
        // Expected: 20

        System.out.println("eval(\"'Hello ' + 'World'\"): " + JSEval.eval("'Hello ' + 'World'"));
        // Expected: Hello World

        System.out.println("eval(\"typeof 42\"): " + JSEval.eval("typeof 42"));
        // Expected: "number"

        System.out.println("eval(\"let x = 5; x * 2\"): " + JSEval.eval("let x = 5; x * 2"));
        // Expected: 10

        System.out.println("eval(\"[1, 2, 3].map(n => n * 2)\"): " + JSEval.eval("[1, 2, 3].map(n => n * 2)"));
        // Expected: [2, 4, 6]
    }
}
