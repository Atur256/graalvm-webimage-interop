package demos.jsObject;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.*;


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
    }
}
