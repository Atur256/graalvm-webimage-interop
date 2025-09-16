package demos.jsFunction;

import builtin.JSFunction;


public class FromConsumerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromConsumer Demo ===");

        // String consumer
        JSFunction stringConsumer = JSFunction.fromGeneralConsumer((String arg) ->
                System.out.println("Consumed String: " + arg));
        stringConsumer.call("Hello");
        // Expected: Consumed String: Hello

        // Integer consumer
        JSFunction intConsumer = JSFunction.fromGeneralConsumer((Integer arg) ->
                System.out.println("Consumed Integer: " + arg));
        intConsumer.call(42);
        // Expected: Consumed Integer: 42

        // Double consumer
        JSFunction doubleConsumer = JSFunction.fromGeneralConsumer((Double arg) ->
                System.out.println("Consumed Double: " + arg));
        doubleConsumer.call(3.14);
        // Expected: Consumed Double: 3.14

        // Boolean consumer
        JSFunction boolConsumer = JSFunction.fromGeneralConsumer((Boolean arg) ->
                System.out.println("Consumed Boolean: " + arg));
        boolConsumer.call(true);
        // Expected: Consumed Boolean: true

        // Custom class consumer
        JSFunction customConsumer = JSFunction.fromGeneralConsumer((CustomClass arg) ->
                System.out.println("Consumed CustomClass: " + arg));
        customConsumer.call(new CustomClass("Alice"));
        // Expected: Consumed CustomClass: CustomClass(Alice)

        // // === BiConsumer: (String, String) → void
        JSFunction biStringConsumer = JSFunction.fromGeneralBiConsumer((String a, String b) ->
                System.out.println("BiConsumer Strings: " + a + " & " + b));
        biStringConsumer.call("Hello", "World");
        // Expected: BiConsumer Strings: Hello & World

        // // === BiConsumer: (String, Integer) → void
        JSFunction biMixedConsumer = JSFunction.fromGeneralBiConsumer((String label, Integer value) ->
                System.out.println("BiConsumer Mixed: " + label + " = " + value.toString()));
        biMixedConsumer.call("Age", 30);
        // Expected: BiConsumer Mixed: Age = 30

        // // === BiConsumer: (CustomClass, CustomClass) → void
        JSFunction biCustomConsumer = JSFunction.fromGeneralBiConsumer((CustomClass a, CustomClass b) ->
                System.out.println("BiConsumer CustomClasses: " + a + " | " + b));
        biCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"));
        // Expected: BiConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob)

        // // === BiTriConsumer: (String, String, String) → void
        JSFunction triStringConsumer = JSFunction.fromGeneralTriConsumer((String a, String b, String c) ->
                System.out.println("TriConsumer Strings: " + a + " & " + b + " & " + c));
        triStringConsumer.call("Hello", "World", "!");
        // Expected: TriConsumer Strings: Hello & World & !

        // // === BiTriConsumer: (String, Integer, Double) → void
        JSFunction triMixedConsumer = JSFunction.fromGeneralTriConsumer((String label, Integer value1, Double value2) ->
                System.out.println("TriConsumer Mixed: " + label + ": " + value1.toString() + " | " + value2.toString()));
        triMixedConsumer.call("Age and Height", 30, 186.35);
        // Expected: TriConsumer Mixed: Age and Height: 30 | 186.35

        // // === BiTriConsumer: (CustomClass, CustomClass, CustomClass) → void
        JSFunction triCustomConsumer = JSFunction.fromGeneralTriConsumer((CustomClass a, CustomClass b, CustomClass c) ->
                System.out.println("TriConsumer CustomClasses: " + a + " | " + b + " | " + c));
        triCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        // Expected: TriConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob) | CustomClass(Anna)
    }

    record CustomClass(String name) {

        @Override
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
