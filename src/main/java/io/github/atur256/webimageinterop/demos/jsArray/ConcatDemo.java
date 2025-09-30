package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ConcatDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.concat Demo ===");

        // Concatenate with JS arrays
        JSArray a1 = JSArray.of(1, 2);
        JSArray a2 = JSArray.of(JSNumber.of(3), JSNumber.of(4));
        JSArray a3 = JSArray.of(5);

        JSArray arr1 = a1.concat(new JSArray[]{a2, a3});
        System.out.println("Concatenated: " + arr1);
        // Expected: Concatenated: [1,2,3,4,5]

        JSArray base = JSArray.of("base");

        // Concatenate with Java arrays
        int[] num = {1, 2, 3};
        String[] fruits = {"apple", "banana"};
        boolean[] flags = {true, false};

        JSArray arr2 = base.concat(num, fruits, flags);
        System.out.println("Result: " + arr2);
        // Expected: Result: [base,1,2,3,apple,banana,true,false]

        // Concatenate with List
        List<String> extras = List.of("x", "y");
        JSArray arr3 = base.concat(extras);
        System.out.println("With List: " + arr3);
        // Expected: With List: [base,x,y]

        // Assert values
        AssertArray.assertArray(arr1, Integer.class, 1, 2, 3, 4, 5);
        assertEquals(8, arr2.length);
        assertEquals("base", JSValue.checkedCoerce(arr2.get(0), String.class));
        assertEquals(Integer.valueOf(1), JSValue.checkedCoerce(arr2.get(1), Integer.class));
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(arr2.get(2), Integer.class));
        assertEquals(Integer.valueOf(3), JSValue.checkedCoerce(arr2.get(3), Integer.class));
        assertEquals("apple", JSValue.checkedCoerce(arr2.get(4), String.class));
        assertEquals("banana", JSValue.checkedCoerce(arr2.get(5), String.class));
        assertEquals(true, JSValue.checkedCoerce(arr2.get(6), Boolean.class));
        assertEquals(false, JSValue.checkedCoerce(arr2.get(7), Boolean.class));
        AssertArray.assertArray(arr3, String.class, "base", "x", "y");
    }
}