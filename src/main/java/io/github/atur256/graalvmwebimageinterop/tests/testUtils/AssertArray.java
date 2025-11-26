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
package io.github.atur256.graalvmwebimageinterop.tests.testUtils;

import io.github.atur256.graalvmwebimageinterop.builtin.JSArray;

import static org.junit.Assert.assertEquals;


public class AssertArray {

    @SafeVarargs
    public static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length);
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], array.get(i, cls));
        }
    }
}
