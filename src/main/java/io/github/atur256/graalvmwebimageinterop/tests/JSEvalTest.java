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

import io.github.atur256.graalvmwebimageinterop.builtin.JSArray;
import io.github.atur256.graalvmwebimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class JSEvalTest {

    public static void main(String[] args) {
        JSObject result6 = JSEval.eval("[1, 2, 3].map(n => n * 2)", JSObject.class);
        JSArray keys = JSValue.checkedCoerce(result6.keys(), JSArray.class);

        assertEquals(Integer.valueOf(4), JSEval.eval("2 + 2", Integer.class));
        assertEquals(Integer.valueOf(20), JSEval.eval("Math.max(10, 20)", Integer.class));
        assertEquals("Hello World", JSEval.eval("'Hello ' + 'World'", String.class));
        assertEquals("number", JSEval.eval("typeof 42", String.class));
        assertEquals(Integer.valueOf(10), JSEval.eval("let x = 5; x * 2", Integer.class));
        assertEquals(3, keys.length);
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(result6.get(0), Integer.class));
        assertEquals(Integer.valueOf(4), JSValue.checkedCoerce(result6.get(1), Integer.class));
        assertEquals(Integer.valueOf(6), JSValue.checkedCoerce(result6.get(2), Integer.class));
    }
}
