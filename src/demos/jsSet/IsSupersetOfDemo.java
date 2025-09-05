package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class IsSupersetOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.isSupersetOf Demo ===");

        JSSet a = new JSSet();
        a.add(JSString.of("apple")).add(JSString.of("banana"));

        JSSet b = new JSSet();
        b.add(JSString.of("apple"));

        System.out.println("Superset? " + a.isSupersetOf(b));
        // Expected Output: Superset? true
    }
}
