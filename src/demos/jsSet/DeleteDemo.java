package demos.jsSet;

import builtin.JSSet;
import org.graalvm.webimage.api.JSString;


public class DeleteDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSet.delete Demo ===");

        JSSet set = new JSSet();
        set.add(JSString.of("banana"));

        boolean deleted = set.delete(JSString.of("banana"));
        System.out.println("Deleted 'banana'? " + deleted);
        // Expected Output: Deleted 'banana'? true
    }
}
