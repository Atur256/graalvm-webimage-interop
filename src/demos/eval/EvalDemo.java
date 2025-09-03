package demos.eval;

import builtin.Eval;


public class EvalDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Eval.eval Demo ===");

        System.out.println("eval(\"2 + 2\"): " + Eval.eval("2 + 2"));
        // Expected: 4

        System.out.println("eval(\"Math.max(10, 20)\"): " + Eval.eval("Math.max(10, 20)"));
        // Expected: 20

        System.out.println("eval(\"'Hello ' + 'World'\"): " + Eval.eval("'Hello ' + 'World'"));
        // Expected: Hello World

        System.out.println("eval(\"typeof 42\"): " + Eval.eval("typeof 42"));
        // Expected: "number"

        System.out.println("eval(\"let x = 5; x * 2\"): " + Eval.eval("let x = 5; x * 2"));
        // Expected: 10

        System.out.println("eval(\"[1, 2, 3].map(n => n * 2)\"): " + Eval.eval("[1, 2, 3].map(n => n * 2)"));
        // Expected: [2, 4, 6]
    }
}
