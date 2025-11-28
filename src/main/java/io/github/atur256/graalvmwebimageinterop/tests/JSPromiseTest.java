/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.atur256.graalvmwebimageinterop.tests;

import io.github.atur256.graalvmwebimageinterop.builtin.*;
import org.graalvm.webimage.api.*;

import java.util.List;

import static io.github.atur256.graalvmwebimageinterop.tests.Asserts.*;


public class JSPromiseTest {

    public static void main(String[] args) {
        testOf();
        testReject();
        testResolve();
        testThen();
        testThenCatchFinally();
        testAll();
        testAllSettled();
        testAny();
        testRace();
        testWithResolvers();
    }

    public static void testOf() {
        JSPromise resolvePromise = JSPromise.of(JSFunction.of((JSValue resolve, JSValue _) -> {
            resolve.as(JSFunction.class).invoke(JSString.of("Hello"));
        }));
        JSPromise rejectPromise = JSPromise.of(JSFunction.of((JSValue _, JSValue reject) -> {
            reject.as(JSFunction.class).invoke(JSString.of("Rejected!"));
        }));
        JSPromise exceptionPromise = JSPromise.of(JSFunction.of((JSValue _, JSValue _) -> {
            throw new RuntimeException("Crash!");
        }));

        resolvePromise
                .then(JSFunction.of((JSString value) ->
                        assertEquals("Hello", value.asString())
                ))
                .catch_(JSFunction.of((Object error) -> fail("Resolve promise should not be rejected: " + error)));
        rejectPromise
                .then(JSFunction.of((JSString _) ->
                        fail("Reject promise should not be fulfilled")
                ))
                .catch_(JSFunction.of((Object error) -> {
                    assertTrue(error instanceof JSString);
                    assertEquals("Rejected!", ((JSString) error).asString());
                }));
        exceptionPromise
                .then(JSFunction.of((JSValue _) ->
                        fail("Exception promise should not be fulfilled")
                ))
                .catch_(JSFunction.of((Object error) -> {
                    assertTrue(error instanceof RuntimeException || error instanceof JSValue);
                    assert error instanceof RuntimeException;
                    assertEquals("Crash!", ((RuntimeException) error).getMessage());
                }));
    }


    public static void testReject() {
        JSPromise resolvedValue = JSPromise.resolve(JSString.of("done:JSValue"));
        JSPromise resolvedInt = JSPromise.resolve(42);
        JSPromise resolvedDouble = JSPromise.resolve(3.14);
        JSPromise resolvedBool = JSPromise.resolve(true);
        JSPromise resolvedObject = JSPromise.resolve("done:Object");

        resolvedValue.then(JSFunction.of((JSString str) ->
                assertEquals("done:JSValue", str.asString())
        ));
        resolvedInt.then(JSFunction.of((JSNumber num) ->
                assertEquals(Integer.valueOf(42), num.asInt())
        ));
        resolvedDouble.then(JSFunction.of((JSNumber num) ->
                assertEquals(3.14, num.asDouble(), 0.0001)
        ));
        resolvedBool.then(JSFunction.of((JSBoolean bool) ->
                assertTrue(bool.asBoolean())));
        resolvedObject.then(JSFunction.of((JSString str) ->
                assertEquals("done:Object", str.asString())
        ));
    }

    public static void testResolve() {
        JSPromise rejectedValue = JSPromise.reject(JSString.of("fail:JSValue"));
        JSPromise rejectedInt = JSPromise.reject(404);
        JSPromise rejectedDouble = JSPromise.reject(9.81);
        JSPromise rejectedBool = JSPromise.reject(false);
        JSPromise rejectedObject = JSPromise.reject("fail:Object");

        rejectedValue.catch_(JSFunction.of((JSString str) ->
                assertEquals("fail:JSValue", str.asString())
        ));
        rejectedInt.catch_(JSFunction.of((JSNumber num) ->
                assertEquals(Integer.valueOf(404), num.asInt())
        ));
        rejectedDouble.catch_(JSFunction.of((JSNumber num) ->
                assertEquals(9.81, num.asDouble(), 0.0001)
        ));
        rejectedBool.catch_(JSFunction.of((JSBoolean bool) ->
                assertFalse(bool.asBoolean())
        ));
        rejectedObject.catch_(JSFunction.of((JSString str) ->
                assertEquals("fail:Object", str.asString())
        ));
    }

    public static void testThen() {
        JSPromise rejectedInt = JSPromise.reject(404);

        rejectedInt.catch_(JSFunction.of((JSNumber num) ->
                assertEquals(Integer.valueOf(404), num.asInt())
        ));
        JSPromise.resolve("chained:success")
                .then(JSFunction.of((JSString str) ->
                        assertEquals("chained:success", str.asString())
                ), JSFunction.of((JSValue _) ->
                        fail("Should not reach rejection handler on resolved promise")
                ));
        JSPromise.reject("chained:fail")
                .then(JSFunction.of((JSValue _) ->
                        fail("Should not reach fulfillment handler on rejected promise")
                ), JSFunction.of((JSString str) ->
                        assertEquals("chained:fail", str.asString())
                ));
    }

    public static void testThenCatchFinally() {
        JSPromise.resolve(42)
                .then(JSFunction.of((JSNumber num) -> JSNumber.of(num.as(Integer.class) + 1)))
                .then(JSFunction.of((JSNumber num) -> {
                    assertEquals(Integer.valueOf(43), num.as(Integer.class));
                    return num;
                }))
                .catch_(JSFunction.of((JSNumber num) -> {
                    fail("Should not reach here!");
                    return num;
                }))
                .finally_(JSFunction.of((JSUndefined undefined) ->
                        assertEquals(JSUndefined.undefined(), undefined)));
    }

    public static void testAll() {
        JSPromise p1 = JSPromise.resolve("One");
        JSPromise p2 = JSPromise.resolve("Two");
        JSPromise p3 = JSPromise.resolve("Three");
        JSPromise p4 = JSPromise.resolve(1);
        JSPromise p5 = JSPromise.resolve(2);
        JSPromise p6 = JSPromise.resolve(3);
        JSPromise p7 = JSPromise.resolve(4);
        JSPromise p8 = JSPromise.resolve(false);
        JSPromise p9 = JSPromise.resolve(true);
        JSPromise allFromJSIterator = JSPromise.all(JSIterator.from(JSArray.of(p1, p2, p3)));
        JSPromise allFromJSArray = JSPromise.all(JSArray.of(p4, p5, p6, p7));
        JSPromise allFromVarargs = JSPromise.all(p1, p2, p3);
        JSPromise allFromList = JSPromise.all(List.of(p8, p9));
        JSPromise emptyAll = JSPromise.all(JSArray.of());

        allFromJSIterator.then(JSFunction.of((JSValue result) ->
                assertArray(result.as(JSArray.class), String.class, "One", "Two", "Three")));
        allFromJSArray.then(JSFunction.of((JSValue result) ->
                assertArray(result.as(JSArray.class), Integer.class, 1, 2, 3, 4)));
        allFromVarargs.then(JSFunction.of((JSValue result) ->
                assertArray(result.as(JSArray.class), String.class, "One", "Two", "Three")));
        allFromList.then(JSFunction.of((JSValue result) ->
                assertArray(result.as(JSArray.class), Boolean.class, false, true)));
        emptyAll.then(JSFunction.of((JSValue value) ->
                assertEquals(0, JSValue.checkedCoerce(value, JSArray.class).length)));
    }

    public static void testAllSettled() {
        JSPromise p1 = JSPromise.resolve("ok");
        JSPromise p2 = JSPromise.reject("fail");
        JSPromise p3 = JSPromise.resolve(1);
        JSPromise p4 = JSPromise.reject(2);
        JSPromise p5 = JSPromise.resolve(true);
        JSPromise p6 = JSPromise.reject(false);
        JSPromise settled1 = JSPromise.allSettled(p1, p2);
        JSPromise settled2 = JSPromise.allSettled(JSIterator.from(JSArray.of(p3, p4)));
        JSPromise settled3 = JSPromise.allSettled(JSArray.of(p1, p2));
        JSPromise settled4 = JSPromise.allSettled(List.of(p5, p6));
        JSPromise emptySettled = JSPromise.allSettled(JSArray.of());

        settled1.then(JSFunction.of((JSValue value) -> {
            JSArray results = JSValue.checkedCoerce(value, JSArray.class);
            JSObject first = results.get(0, JSObject.class);
            JSObject second = results.get(1, JSObject.class);
            assertEquals("fulfilled", first.get("status", String.class));
            assertEquals("ok", first.get("value", String.class));
            assertEquals("rejected", second.get("status", String.class));
            assertEquals("fail", second.get("reason", String.class));
        }));
        settled2.then(JSFunction.of((JSValue value) -> {
            JSArray results = JSValue.checkedCoerce(value, JSArray.class);
            JSObject first = results.get(0, JSObject.class);
            JSObject second = results.get(1, JSObject.class);
            assertEquals("fulfilled", first.get("status", String.class));
            assertEquals(Integer.valueOf(1), first.get("value", Integer.class));
            assertEquals("rejected", second.get("status", String.class));
            assertEquals(Integer.valueOf(2), second.get("reason", Integer.class));
        }));
        settled3.then(JSFunction.of((JSValue value) -> {
            JSArray results = JSValue.checkedCoerce(value, JSArray.class);
            JSObject first = results.get(0, JSObject.class);
            JSObject second = results.get(1, JSObject.class);
            assertEquals("fulfilled", first.get("status", String.class));
            assertEquals("ok", first.get("value", String.class));
            assertEquals("rejected", second.get("status", String.class));
            assertEquals("fail", second.get("reason", String.class));
        }));
        settled4.then(JSFunction.of((JSValue value) -> {
            JSArray results = JSValue.checkedCoerce(value, JSArray.class);
            JSObject first = results.get(0, JSObject.class);
            JSObject second = results.get(1, JSObject.class);
            assertEquals("fulfilled", first.get("status", String.class));
            assertTrue(first.get("value", Boolean.class));
            assertEquals("rejected", second.get("status", String.class));
            assertFalse(second.get("reason", Boolean.class));
        }));
        emptySettled.then(
                JSFunction.of((JSValue value) ->
                        assertEquals(0, JSValue.checkedCoerce(value, JSArray.class).length)));
    }

    public static void testAny() {
        JSPromise p1Resolved = JSPromise.resolve("First");
        JSPromise p1Reject = JSPromise.reject("First");
        JSPromise p2Resolved = JSPromise.resolve("Second");
        JSPromise p2Reject = JSPromise.reject("Second");
        JSPromise p3Resolved = JSPromise.resolve("Third");
        JSPromise p3Reject = JSPromise.reject("Third");
        JSPromise anyFromJSIterator = JSPromise.any(JSIterator.from(JSArray.of(p1Resolved, p2Resolved, p3Reject)));
        JSPromise anyFromJSArray = JSPromise.any(JSArray.of(p1Reject, p2Resolved, p3Resolved));
        JSPromise anyFromVarargs = JSPromise.any(p1Reject, p2Reject, p3Resolved);
        JSPromise anyFromList = JSPromise.any(List.of(p1Reject, p2Reject, p3Resolved));
        JSPromise anyFail = JSPromise.any(JSPromise.reject("A"), JSPromise.reject("B"));

        anyFromJSIterator.then(JSFunction.of((JSValue result) ->
                assertEquals("First", result.as(String.class))));
        anyFromJSArray.then(JSFunction.of((JSString result) ->
                assertEquals("Second", result.as(String.class))));
        anyFromVarargs.then(JSFunction.of((JSString result) ->
                assertEquals("Third", result.as(String.class))));
        anyFromList.then(JSFunction.of((JSString result) ->
                assertEquals("Third", result.as(String.class))));
        anyFail.catch_(JSFunction.of((JSValue value) ->
                assertEquals("All promises were rejected",
                        value.as(JSObject.class).get("message", String.class))));
    }

    public static void testRace() {
        JSPromise p1 = JSPromise.resolve("Winner A");
        JSPromise p1Reject = JSPromise.reject("Loser A");
        JSPromise p2 = JSPromise.resolve("Winner B");
        JSPromise p2Reject = JSPromise.reject("Loser B");
        JSPromise p3 = JSPromise.resolve("Winner C");
        JSPromise raceFromIterator = JSPromise.race(JSIterator.from(JSArray.of(p1, p2, p3)));
        JSPromise raceFromArray = JSPromise.race(JSArray.of(p1Reject, p2, p3));
        JSPromise raceFromVarargs = JSPromise.race(p1Reject, p2Reject, p3);
        JSPromise raceFromList = JSPromise.race(List.of(p1Reject, p2Reject, p3));

        raceFromIterator.then(JSFunction.of((JSValue result) ->
                assertEquals("Winner A", result.as(String.class))));
        raceFromArray.then(JSFunction.of((JSValue result) ->
                assertEquals("Winner B", result.as(String.class))));
        raceFromVarargs.then(JSFunction.of((JSValue result) ->
                assertEquals("Winner C", result.as(String.class))));
        raceFromList.then(JSFunction.of((JSValue result) ->
                assertEquals("Winner C", result.as(String.class))));
    }

    public static void testWithResolvers() {
        JSObject resolvedPair = JSPromise.withResolvers();
        JSFunction resolve = resolvedPair.get("resolve", JSFunction.class);
        JSPromise resolvedPromise = resolvedPair.get("promise", JSPromise.class);
        resolvedPromise
                .then(JSFunction.of((JSValue value) ->
                        assertEquals("manual resolution", JSValue.checkedCoerce(value, String.class))))
                .catch_(JSFunction.of((JSValue _) -> fail("Should not reach here!")));
        JSObject rejectedPair = JSPromise.withResolvers();
        JSFunction reject = rejectedPair.get("reject", JSFunction.class);
        JSPromise rejectedPromise = rejectedPair.get("promise", JSPromise.class);
        rejectedPromise
                .then(JSFunction.of((JSValue _) -> fail("Should not reach here!")))
                .catch_(JSFunction.of((JSValue value) ->
                        assertEquals("manual rejection", JSValue.checkedCoerce(value, String.class))));

        resolve.invoke(JSString.of("manual resolution"));
        reject.invoke(JSString.of("manual rejection"));
    }
}
