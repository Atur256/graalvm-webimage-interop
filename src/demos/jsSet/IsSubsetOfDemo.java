package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class IsSubsetOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isSubsetOf Demo ===");

        JSSet a = new JSSet();
        a.add(JSString.of("apple"));

        JSSet b = new JSSet();
        b.add(JSString.of("apple")).add(JSString.of("banana"));

        System.out.println("Subset? " + a.isSubsetOf(b));
        // Expected Output: Subset? true
    }
}
