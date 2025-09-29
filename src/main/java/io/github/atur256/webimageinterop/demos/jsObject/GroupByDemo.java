package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.*;

import static org.junit.Assert.assertEquals;


public class GroupByDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.groupBy Demo ===");

        JSArray items = new JSArray();
        JSObject obj1 = JSObject.create();
        obj1.set("name", "asparagus");
        obj1.set("type", "vegetables");
        obj1.set("quantity", 5);
        JSObject obj2 = JSObject.create();
        obj2.set("name", "bananas");
        obj2.set("type", "fruit");
        obj2.set("quantity", 0);
        JSObject obj3 = JSObject.create();
        obj3.set("name", "cherries");
        obj3.set("type", "fruit");
        obj3.set("quantity", 5);
        JSObject obj4 = JSObject.create();
        obj4.set("name", "goat");
        obj4.set("type", "meat");
        obj4.set("quantity", 23);
        JSObject obj5 = JSObject.create();
        obj5.set("name", "fish");
        obj5.set("type", "meat");
        obj5.set("quantity", 22);
        items.push(obj1);
        items.push(obj2);
        items.push(obj3);
        items.push(obj4);
        items.push(obj5);
        JSFunction groupByType = JSFunction.fromGeneralFunction((JSObject item) -> item.get("type"));

        JSObject grouped = JSObject.groupBy(items, groupByType);
        JSArray keys = JSValue.checkedCoerce(JSObject.keys(grouped), JSArray.class);

        for(int i = 0; i < keys.length; i++) {
            String key = ((JSValue) keys.get(i)).as(String.class);
            System.out.println("Group: " + key);
            JSArray groupItems = ((JSValue) grouped.get(key)).as(JSArray.class);
            for(int j = 0; j < groupItems.length; j++) {
                JSObject obj = (JSObject) groupItems.get(j);
                System.out.println("  - " + obj.get("name"));
            }
        }
        // Expected;
        // Group: vegetables
        //         - asparagus
        // Group: fruit
        //         - bananas
        //         - cherries
        // Group: meat
        //         - goat
        //         - fish

        // Assert values
        AssertArray.assertArray(keys, String.class,"vegetables", "fruit", "meat");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("vegetables"), JSArray.class), "asparagus");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("fruit"), JSArray.class), "bananas", "cherries");
        assertInnerArray(JSValue.checkedCoerce(grouped.get("meat"), JSArray.class), "goat", "fish");
    }

    @SafeVarargs
    private static <T> void assertInnerArray(JSArray array, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], JSValue.checkedCoerce(JSValue.checkedCoerce(array.get(i), JSObject.class).get("name"), String.class));
        }
    }
}