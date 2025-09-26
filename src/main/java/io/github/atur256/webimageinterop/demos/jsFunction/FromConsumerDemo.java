package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.jetbrains.annotations.NotNull;

import static org.junit.Assert.assertEquals;


public class FromConsumerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromConsumer Demo ===");

        // String consumer
        String[] result1 = new String[]{""};
        JSFunction stringConsumer = JSFunction.fromGeneralConsumer((String arg) -> {
            result1[0] = "Consumed String: " + arg;
            System.out.println(result1[0]);
        });
        stringConsumer.call("Hello");
        assertEquals("Consumed String: Hello", result1[0]);
        // Expected: Consumed String: Hello

        // Integer consumer
        String[] result2 = new String[]{""};
        JSFunction intConsumer = JSFunction.fromGeneralConsumer((Integer arg) -> {
            result2[0] = "Consumed Integer: " + arg;
            System.out.println(result2[0]);
        });
        intConsumer.call(42);
        assertEquals("Consumed Integer: 42", result2[0]);
        // Expected: Consumed Integer: 42

        // Double consumer
        String[] result3 = new String[]{""};
        JSFunction doubleConsumer = JSFunction.fromGeneralConsumer((Double arg) -> {
            result3[0] = "Consumed Double: " + arg;
            System.out.println(result3[0]);
        });
        doubleConsumer.call(3.14);
        assertEquals("Consumed Double: 3.14", result3[0]);
        // Expected: Consumed Double: 3.14

        // Boolean consumer
        String[] result4 = new String[]{""};
        JSFunction boolConsumer = JSFunction.fromGeneralConsumer((Boolean arg) -> {
            result4[0] = "Consumed Boolean: " + arg;
            System.out.println(result4[0]);
        });
        boolConsumer.call(true);
        assertEquals("Consumed Boolean: true", result4[0]);
        // Expected: Consumed Boolean: true

        // Custom class consumer
        String[] result5 = new String[]{""};
        JSFunction customConsumer = JSFunction.fromGeneralConsumer((CustomClass arg) -> {
            result5[0] = "Consumed CustomClass: " + arg;
            System.out.println(result5[0]);
        });
        customConsumer.call(new CustomClass("Alice"));
        assertEquals("Consumed CustomClass: CustomClass(Alice)", result5[0]);
        // Expected: Consumed CustomClass: CustomClass(Alice)

        // BiConsumer: (String, String) → void
        String[] result6 = new String[]{""};
        JSFunction biStringConsumer = JSFunction.fromGeneralBiConsumer((String a, String b) -> {
            result6[0] = "BiConsumer Strings: " + a + " & " + b;
            System.out.println(result6[0]);
        });
        biStringConsumer.call("Hello", "World");
        assertEquals("BiConsumer Strings: Hello & World", result6[0]);
        // Expected: BiConsumer Strings: Hello & World

        // BiConsumer: (String, Integer) → void
        String[] result7 = new String[]{""};
        JSFunction biMixedConsumer = JSFunction.fromGeneralBiConsumer((String label, Integer value) -> {
            result7[0] = "BiConsumer Mixed: " + label + " = " + value.toString();
            System.out.println(result7[0]);
        });
        biMixedConsumer.call("Age", 30);
        assertEquals("BiConsumer Mixed: Age = 30", result7[0]);
        // Expected: BiConsumer Mixed: Age = 30

        // BiConsumer: (CustomClass, CustomClass) → void
        String[] result8 = new String[]{""};
        JSFunction biCustomConsumer = JSFunction.fromGeneralBiConsumer((CustomClass a, CustomClass b) -> {
            result8[0] = "BiConsumer CustomClasses: " + a + " | " + b;
            System.out.println(result8[0]);
        });
        biCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"));
        assertEquals("BiConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob)", result8[0]);
        // Expected: BiConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob)

        // BiTriConsumer: (String, String, String) → void
        String[] result9 = new String[]{""};
        JSFunction triStringConsumer = JSFunction.fromGeneralTriConsumer((String a, String b, String c) -> {
            result9[0] = "TriConsumer Strings: " + a + " & " + b + " & " + c;
            System.out.println(result9[0]);
        });
        triStringConsumer.call("Hello", "World", "!");
        assertEquals("TriConsumer Strings: Hello & World & !", result9[0]);
        // Expected: TriConsumer Strings: Hello & World & !

        // BiTriConsumer: (String, Integer, Double) → void
        String[] result10 = new String[]{""};
        JSFunction triMixedConsumer = JSFunction.fromGeneralTriConsumer((String label, Integer value1, Double value2) -> {
            result10[0] = "TriConsumer Mixed: " + label + ": " + value1.toString() + " | " + value2.toString();
            System.out.println(result10[0]);
        });
        triMixedConsumer.call("Age and Height", 30, 186.35);
        assertEquals("TriConsumer Mixed: Age and Height: 30 | 186.35", result10[0]);
        // Expected: TriConsumer Mixed: Age and Height: 30 | 186.35

        // BiTriConsumer: (CustomClass, CustomClass, CustomClass) → void
        String[] result11 = new String[]{""};
        JSFunction triCustomConsumer = JSFunction.fromGeneralTriConsumer((CustomClass a, CustomClass b, CustomClass c) -> {
            result11[0] = "TriConsumer CustomClasses: " + a + " | " + b + " | " + c;
            System.out.println(result11[0]);
        });
        triCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        assertEquals("TriConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob) | CustomClass(Anna)", result11[0]);
        // Expected: TriConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob) | CustomClass(Anna)
    }

    record CustomClass(String name) {

        @Override
        @NotNull
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
