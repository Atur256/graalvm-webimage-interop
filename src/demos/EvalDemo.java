package demos;

import builtin.Eval;
import org.graalvm.webimage.api.JSValue;


public class EvalDemo {

    public static void main(String[] args) {

        evaluateAndPrint("2 + 2");

        evaluateAndPrint("3 * 4 + 3");

        evaluateAndPrint("2 + a");

    }

    private static void evaluateAndPrint(String expression) {
        try {
            JSValue result = Eval.eval(expression);
            System.out.println("Output for \"" + expression + "\" is: " + result);
        } catch (Exception e) {
            System.out.println("Error evaluating \"" + expression + "\": " + e.getMessage());
        }
    }
}
