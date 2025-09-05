package demos.jsRegExp;

import builtin.JSRegExp;


public class UnicodeSetsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSRegExp.unicodeSets Demo ===");

        JSRegExp regex = JSRegExp.of("\\p{Script=Latin}", "v");
        System.out.println("Unicode sets? " + regex.unicodeSets);
        // Expected Output: Unicode sets? true
    }
}
