package demos.jsFunction;

import builtin.JSFunction;


public class FromConsumerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromConsumer Demo ===");

        // String consumer
        JSFunction stringConsumer = JSFunction.fromConsumer((String arg) ->
                System.out.println("Consumed String: " + arg));
        stringConsumer.call("Hello");
        // Expected: Consumed String: Hello

        // Integer consumer
        JSFunction intConsumer = JSFunction.fromConsumer((Integer arg) ->
                System.out.println("Consumed Integer: " + arg));
        intConsumer.call(42);
        // Expected: Consumed Integer: 42

        // Double consumer
        JSFunction doubleConsumer = JSFunction.fromConsumer((Double arg) ->
                System.out.println("Consumed Double: " + arg));
        doubleConsumer.call(3.14);
        // Expected: Consumed Double: 3.14

        // Boolean consumer
        JSFunction boolConsumer = JSFunction.fromConsumer((Boolean arg) ->
                System.out.println("Consumed Boolean: " + arg));
        boolConsumer.call(true);
        // Expected: Consumed Boolean: true

        // Custom class consumer
        JSFunction customConsumer = JSFunction.fromConsumer((CustomClass arg) ->
                System.out.println("Consumed CustomClass: " + arg));
        customConsumer.call(new CustomClass("Alice"));
        // Expected: Consumed CustomClass: CustomClass(Alice)
    }

    record CustomClass(String name) {

        @Override
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
