package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class IsDisjointFromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isDisjointFrom Demo ===");

        JSSet a = new JSSet();
        a.add(JSString.of("apple"));

        JSSet b = new JSSet();
        b.add(JSString.of("banana"));

        System.out.println("Disjoint? " + a.isDisjointFrom(b));
        // Expected Output: Disjoint? true
    }
}
