package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FromConsumerDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromConsumer Demo ===");

        // String consumer
        AtomicReference<String> captured1 = new AtomicReference<>();
        JSFunction stringConsumer = JSFunction.fromGeneralConsumer((String arg) -> {
            captured1.set(arg);
            System.out.println("Consumed String: " + arg);
        });
        stringConsumer.call("Hello");
        // Expected: Consumed String: Hello

        // Integer consumer
        AtomicReference<Integer> captured2 = new AtomicReference<>();
        JSFunction intConsumer = JSFunction.fromGeneralConsumer((Integer arg) -> {
            captured2.set(arg);
            System.out.println("Consumed Integer: " + arg);
        });
        intConsumer.call(42);
        // Expected: Consumed Integer: 42

        // Double consumer
        AtomicReference<Double> captured3 = new AtomicReference<>();
        JSFunction doubleConsumer = JSFunction.fromGeneralConsumer((Double arg) -> {
            captured3.set(arg);
            System.out.println("Consumed Double: " + arg);
        });
        doubleConsumer.call(3.14);
        // Expected: Consumed Double: 3.14

        // Boolean consumer
        AtomicReference<Boolean> captured4 = new AtomicReference<>();
        JSFunction boolConsumer = JSFunction.fromGeneralConsumer((Boolean arg) -> {
            captured4.set(arg);
            System.out.println("Consumed Boolean: " + arg);
        });
        boolConsumer.call(true);
        // Expected: Consumed Boolean: true

        // Custom class consumer
        AtomicReference<CustomClass> captured5 = new AtomicReference<>();
        JSFunction customConsumer = JSFunction.fromGeneralConsumer((CustomClass arg) -> {
            captured5.set(arg);
            System.out.println("Consumed CustomClass: " + arg);
        });
        customConsumer.call(new CustomClass("Alice"));
        // Expected: Consumed CustomClass: CustomClass(Alice)

        // BiConsumer: (String, String) → void
        AtomicReference<Pair<String, String>> captured6 = new AtomicReference<>();
        JSFunction biStringConsumer = JSFunction.fromGeneralBiConsumer((String a, String b) -> {
            captured6.set(Pair.of(a, b));
            System.out.println("BiConsumer Strings: " + a + " & " + b);
        });
        biStringConsumer.call("Hello", "World");
        // Expected: BiConsumer Strings: Hello & World

        // BiConsumer: (String, Integer) → void
        AtomicReference<Pair<String, Integer>> captured7 = new AtomicReference<>();
        JSFunction biMixedConsumer = JSFunction.fromGeneralBiConsumer((String label, Integer value) -> {
            captured7.set(Pair.of(label, value));
            System.out.println("BiConsumer Mixed: " + label + " = " + value.toString());
        });
        biMixedConsumer.call("Age", 30);
        // Expected: BiConsumer Mixed: Age = 30

        // BiConsumer: (CustomClass, CustomClass) → void
        AtomicReference<Pair<CustomClass, CustomClass>> captured8 = new AtomicReference<>();
        JSFunction biCustomConsumer = JSFunction.fromGeneralBiConsumer((CustomClass a, CustomClass b) -> {
            captured8.set(Pair.of(a, b));
            System.out.println("BiConsumer CustomClasses: " + a + " | " + b);
        });
        biCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"));
        // Expected: BiConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob)

        // BiTriConsumer: (String, String, String) → void
        AtomicReference<Triple<String, String, String>> captured9 = new AtomicReference<>();
        JSFunction triStringConsumer = JSFunction.fromGeneralTriConsumer((String a, String b, String c) -> {
            captured9.set(Triple.of(a, b, c));
            System.out.println("TriConsumer Strings: " + a + " & " + b + " & " + c);
        });
        triStringConsumer.call("Hello", "World", "!");
        // Expected: TriConsumer Strings: Hello & World & !

        // BiTriConsumer: (String, Integer, Double) → void
        AtomicReference<Triple<String, Integer, Double>> captured10 = new AtomicReference<>();
        JSFunction triMixedConsumer = JSFunction.fromGeneralTriConsumer((String label, Integer value1, Double value2) -> {
            captured10.set(Triple.of(label, value1, value2));
            System.out.println("TriConsumer Mixed: " + label + ": " + value1.toString() + " | " + value2.toString());
        });
        triMixedConsumer.call("Age and Height", 30, 186.35);
        // Expected: TriConsumer Mixed: Age and Height: 30 | 186.35

        // BiTriConsumer: (CustomClass, CustomClass, CustomClass) → void
        AtomicReference<Triple<CustomClass, CustomClass, CustomClass>> captured11 = new AtomicReference<>();
        JSFunction triCustomConsumer = JSFunction.fromGeneralTriConsumer((CustomClass a, CustomClass b, CustomClass c) -> {
            captured11.set(Triple.of(a, b, c));
            System.out.println("TriConsumer CustomClasses: " + a + " | " + b + " | " + c);
        });
        triCustomConsumer.call(new CustomClass("Alice"), new CustomClass("Bob"), new CustomClass("Anna"));
        // Expected: TriConsumer CustomClasses: CustomClass(Alice) | CustomClass(Bob) | CustomClass(Anna)

        // Assert values
        assertEquals("Hello", captured1.get());
        assertEquals(Integer.valueOf(42), captured2.get());
        assertEquals(3.14, captured3.get(), 0.0);
        assertTrue(captured4.get());
        assertEquals(new CustomClass("Alice"), captured5.get());
        assertEquals("Hello", captured6.get().a);
        assertEquals("World", captured6.get().b);
        assertEquals("Age", captured7.get().a);
        assertEquals(Integer.valueOf(30), captured7.get().b);
        assertEquals(new CustomClass("Alice"), captured8.get().a);
        assertEquals(new CustomClass("Bob"), captured8.get().b);
        assertEquals("Hello", captured9.get().a);
        assertEquals("World", captured9.get().b);
        assertEquals("!", captured9.get().c);
        assertEquals("Age and Height", captured10.get().a);
        assertEquals(Integer.valueOf(30), captured10.get().b);
        assertEquals(186.35, captured10.get().c, 0.0);
        assertEquals(new CustomClass("Alice"), captured11.get().a);
        assertEquals(new CustomClass("Bob"), captured11.get().b);
        assertEquals(new CustomClass("Anna"), captured11.get().c);
    }

    record CustomClass(String name) {

        @Override
        @NotNull
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }

    // Records for value capturing for assertions
    public record Pair<A, B>(A a, B b) {

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }
    }

    public record Triple<A, B, C>(A a, B b, C c) {


        public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
            return new Triple<>(a, b, c);
        }
    }
}