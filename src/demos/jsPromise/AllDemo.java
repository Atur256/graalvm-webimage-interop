package demos.jsPromise;

import builtin.JSArray;
import builtin.JSIterator;
import builtin.JSPromise;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSValue;

import java.util.List;


public class AllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.all Demo ===");

        JSPromise p1 = JSPromise.resolve("One");
        JSPromise p2 = JSPromise.resolve("Two");
        JSPromise p3 = JSPromise.resolve("Three");

        // --- Using JSIterator directly ---
        JSArray jsArray = JSArray.of();
        jsArray.push(p1);
        jsArray.push(p2);
        jsArray.push(p3);

        JSIterator jsIterator = JSIterator.from(jsArray);
        JSPromise allFromJSIterator = JSPromise.all(jsIterator);
        allFromJSIterator.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from JSIterator: " + result.as(JSArray.class))));
        // Expected: Result from JSIterator: [One,Two,Three]

        // --- Using JSArray ---
        JSPromise allFromJSArray = JSPromise.all(jsArray);
        allFromJSArray.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from JSArray: " + result.as(JSArray.class))));
        // Expected: Result from JSArray: [One,Two,Three]

        // --- Using varargs ---
        JSPromise allFromVarargs = JSPromise.all(p1, p2, p3);
        allFromVarargs.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from varargs: " + result.as(JSArray.class))));
        // Expected: Result from varargs: [One,Two,Three]

        // --- Using List<JSPromise> ---
        List<JSPromise> promiseList = List.of(p1, p2, p3);
        JSPromise allFromList = JSPromise.all(promiseList);
        allFromList.then(JSFunction.fromGeneralConsumer((JSValue result) ->
                System.out.println("Result from List: " + result.as(JSArray.class))));
        // Expected: Result from List: [One,Two,Three]
    }
}
