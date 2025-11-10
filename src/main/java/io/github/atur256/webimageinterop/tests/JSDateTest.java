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

package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSDate;

import static org.junit.Assert.assertEquals;


public class JSDateTest {

    // Note: This test suite excludes functions that produce localization-dependent output,
    // such as toLocaleString(), toTimeString(), and local time getters/setters.
    // These values vary across time zones and system locales, making them unsuitable for deterministic testing.

    public static void main(String[] args) {
        testCreateFromLong();
        testCreateFromDateString();
        testCreateFromComponents();
        testUTC();
        testGetters();
        testSetters();
        testUTCSetters();
        testToString();
    }

    public static void testCreateFromLong() {
        long timestamp = JSDate.parse("2025-10-07T13:12:00Z");

        JSDate date = JSDate.create(timestamp);

        assertEquals(2025, date.getUTCFullYear());
        assertEquals(9, date.getUTCMonth());
        assertEquals(7, date.getUTCDate());
        assertEquals(13, date.getUTCHours());
        assertEquals(12, date.getUTCMinutes());
        assertEquals(0, date.getUTCSeconds());
    }

    public static void testCreateFromDateString() {
        JSDate date = JSDate.create("2025-10-07T13:12:00Z");

        assertEquals(2025, date.getUTCFullYear());
        assertEquals(9, date.getUTCMonth());
        assertEquals(7, date.getUTCDate());
        assertEquals(13, date.getUTCHours());
        assertEquals(12, date.getUTCMinutes());
        assertEquals(0, date.getUTCSeconds());
    }

    public static void testCreateFromComponents() {
        JSDate date1 = JSDate.create(2025, 9);
        JSDate date2 = JSDate.create(2025, 9, 7);
        JSDate date3 = JSDate.create(2025, 9, 7, 13);
        JSDate date4 = JSDate.create(2025, 9, 7, 13, 12);
        JSDate date5 = JSDate.create(2025, 9, 7, 13, 12, 11);
        JSDate date6 = JSDate.create(2025, 9, 7, 13, 12, 11, 123);

        assertEquals(2025, date1.getFullYear());
        assertEquals(9, date1.getMonth());
        assertEquals(1, date1.getDate());
        assertEquals(0, date1.getHours());
        assertEquals(0, date1.getMinutes());
        assertEquals(0, date1.getSeconds());
        assertEquals(0, date1.getMilliseconds());
        assertEquals(2025, date2.getFullYear());
        assertEquals(9, date2.getMonth());
        assertEquals(7, date2.getDate());
        assertEquals(0, date2.getHours());
        assertEquals(0, date2.getMinutes());
        assertEquals(0, date2.getSeconds());
        assertEquals(0, date2.getMilliseconds());
        assertEquals(2025, date3.getFullYear());
        assertEquals(9, date3.getMonth());
        assertEquals(7, date3.getDate());
        assertEquals(13, date3.getHours());
        assertEquals(0, date3.getMinutes());
        assertEquals(0, date3.getSeconds());
        assertEquals(0, date3.getMilliseconds());
        assertEquals(2025, date4.getFullYear());
        assertEquals(9, date4.getMonth());
        assertEquals(7, date4.getDate());
        assertEquals(13, date4.getHours());
        assertEquals(12, date4.getMinutes());
        assertEquals(0, date4.getSeconds());
        assertEquals(0, date4.getMilliseconds());
        assertEquals(2025, date5.getFullYear());
        assertEquals(9, date5.getMonth());
        assertEquals(7, date5.getDate());
        assertEquals(13, date5.getHours());
        assertEquals(12, date5.getMinutes());
        assertEquals(11, date5.getSeconds());
        assertEquals(0, date5.getMilliseconds());
        assertEquals(2025, date6.getFullYear());
        assertEquals(9, date6.getMonth());
        assertEquals(7, date6.getDate());
        assertEquals(13, date6.getHours());
        assertEquals(12, date6.getMinutes());
        assertEquals(11, date6.getSeconds());
        assertEquals(123, date6.getMilliseconds());
    }

    public static void testUTC() {
        long utc1 = JSDate.UTC(2025, 9);
        long utc2 = JSDate.UTC(2025, 9, 7);
        long utc3 = JSDate.UTC(2025, 9, 7, 13);
        long utc4 = JSDate.UTC(2025, 9, 7, 13, 12);
        long utc5 = JSDate.UTC(2025, 9, 7, 13, 12, 11);
        long utc6 = JSDate.UTC(2025, 9, 7, 13, 12, 11, 123);

        assertEquals(1759276800000L, utc1);
        assertEquals(1759795200000L, utc2);
        assertEquals(1759842000000L, utc3);
        assertEquals(1759842720000L, utc4);
        assertEquals(1759842731000L, utc5);
        assertEquals(1759842731123L, utc6);
    }

    public static void testGetters() {
        JSDate date = JSDate.create("2025-10-07T13:12:00.123Z");

        assertEquals(7, date.getUTCDate());
        assertEquals(2, date.getUTCDay());
        assertEquals(2025, date.getUTCFullYear());
        assertEquals(13, date.getUTCHours());
        assertEquals(123, date.getUTCMilliseconds());
        assertEquals(12, date.getUTCMinutes());
        assertEquals(9, date.getUTCMonth());
        assertEquals(0, date.getUTCSeconds());
    }

    public static void testSetters() {
        JSDate date = JSDate.create("2000-01-01T00:00:00.000Z");
        long timestamp = JSDate.parse("2025-10-07T13:12:00.123Z");

        date.setTime(timestamp);

        assertEquals(2025, date.getUTCFullYear());
        assertEquals(9, date.getUTCMonth());
        assertEquals(7, date.getUTCDate());
        assertEquals(13, date.getUTCHours());
        assertEquals(12, date.getUTCMinutes());
        assertEquals(0, date.getUTCSeconds());
        assertEquals(123, date.getUTCMilliseconds());
        assertEquals(1759842720123L, date.getTime());
    }

    public static void testUTCSetters() {
        JSDate date = JSDate.create("2025-01-01T00:00:00.000Z");

        date.setUTCFullYear(2035);
        date.setUTCMonth(6);
        date.setUTCDate(20);
        date.setUTCHours(14);
        date.setUTCMinutes(45);
        date.setUTCSeconds(59);
        date.setUTCMilliseconds(321);

        assertEquals(2035, date.getUTCFullYear());
        assertEquals(6, date.getUTCMonth());
        assertEquals(20, date.getUTCDate());
        assertEquals(14, date.getUTCHours());
        assertEquals(45, date.getUTCMinutes());
        assertEquals(59, date.getUTCSeconds());
        assertEquals(321, date.getUTCMilliseconds());
    }

    public static void testToString() {
        JSDate date = JSDate.create("2025-10-07T13:12:00.123Z");

        assertEquals("2025-10-07T13:12:00.123Z", date.toISOString());
        assertEquals("2025-10-07T13:12:00.123Z", date.toJSON());
        assertEquals("Tue, 07 Oct 2025 13:12:00 GMT", date.toUTCString());
    }
}
