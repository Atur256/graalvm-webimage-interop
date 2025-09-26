package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.from Demo ===");

        // JSString → JSArray of characters
        JSArray arr1 = JSArray.from(JSString.of("hello"));
        assertArray(arr1, String.class, "h","e","l","l","o");
        System.out.println("JSArray length: " + arr1.length);
        System.out.println("JSArray: " + arr1);
        // Expected:
        // JSArray length: 5
        // JSArray: [h,e,l,l,o]

        //  Java String → JSArray of characters
        JSArray arr2 = JSArray.from("Hello");
        assertArray(arr2, String.class, "H","e","l","l","o");
        System.out.println("JSArray length: " + arr2.length);
        System.out.println("JSArray: " + arr2);
        // Expected:
        // JSArray length: 5
        // JSArray: [H,e,l,l,o]

        //  Java String[] → JSArray
        JSArray arr3 = JSArray.from(new String[]{"Alice", "Bob", "Charlie"});
        assertArray(arr3, String.class, "Alice", "Bob", "Charlie");
        System.out.println("JSArray length: " + arr3.length);
        System.out.println("JSArray: " + arr3);
        // Expected:
        // JSArray length: 3
        // JSArray: [Alice,Bob,Charlie]

        //  Java int[] → JSArray
        JSArray arr4 = JSArray.from(new int[]{10, 20, 30});
        assertArray(arr4, Integer.class, 10,20,30);
        System.out.println("JSArray length: " + arr4.length);
        System.out.println("JSArray: " + arr4);
        // Expected:
        // JSArray length: 3
        // JSArray: [10,20,30]

        //  Java double[] → JSArray
        JSArray arr5 = JSArray.from(new double[]{9.99, 14.99, 29.99});
        assertArray(arr5, Double.class, 9.99, 14.99, 29.99);
        System.out.println("JSArray length: " + arr5.length);
        System.out.println("JSArray: " + arr5);
        // Expected:
        // JSArray length: 3
        // JSArray: [9.99,14.99,29.99]

        //  Java boolean[] → JSArray
        boolean[] flags = {true, false, true};
        JSArray arr6 = JSArray.from(flags);
        assertArray(arr6, Boolean.class, true,false,true);
        System.out.println("JSArray length: " + arr6.length);
        System.out.println("JSArray: " + arr6);
        // Expected:
        // JSArray length: 3
        // JSArray: [true,false,true]

        //  Custom class[] → JSArray of strings
        JSArray arr7 = JSArray.from(new Custom[]{new Custom("X"), new Custom("Y")});
        assertArray(arr7, Custom.class, new Custom("X"), new Custom("Y"));
        System.out.println("JSArray length: " + arr7.length);
        System.out.println("JSArray: " + arr7);
        // Expected:
        // JSArray length: 2
        // JSArray: [Custom(X),Custom(Y)]
    }

    // Simple class for custom object
    static class Custom {

        public String label;

        public Custom(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Custom(" + label + ")";
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Custom other && label.equals(other.label);
        }

        @Override
        public int hashCode() {
            return label.hashCode();
        }
    }

    @SafeVarargs
    private static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(array.get(i), cls));
        }
    }
}
