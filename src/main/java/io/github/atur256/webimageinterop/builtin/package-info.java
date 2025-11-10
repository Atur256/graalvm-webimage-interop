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

/**
 * Provides Java bindings for core JavaScript objects and functions within the WebImage interop layer.
 * <p>
 * This package enables seamless interaction between Java and JavaScript using GraalVM's {@link org.graalvm.webimage.api.JS} annotations.
 * Each class in this package corresponds to a native JavaScript construct—such as {@code Array}, {@code Promise}, {@code Function}, or {@code Math}—
 * and exposes its behavior through idiomatic Java interfaces.
 * </p>
 *
 * <p><b>Key Features:</b></p>
 * <ul>
 *   <li>Interop with JavaScript primitives, collections, and built-ins</li>
 *   <li>Support for asynchronous operations via {@link io.github.atur256.webimageinterop.builtin.JSPromise}</li>
 *   <li>Functional interfaces for callbacks and transformations</li>
 *   <li>Native access to JavaScript evaluation, internationalization, and regular expressions</li>
 * </ul>
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSArray arr = JSArray.of(1, 2, 3);
 * arr.push(4);
 *
 * JSPromise promise = JSPromise.resolve("done");
 * promise.then(JSFunction.fromRun(() -> JSValue.of("finished")));
 * }</pre>
 *
 * <p><b>Included Bindings:</b></p>
 * <ul>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSArray}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSDate}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSError}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSEval}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSFunction}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSIntl}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSIterator}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSJson}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSMap}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSMath}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSPromise}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSRegExp}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSSet}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.JSUri}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.TriConsumer}</li>
 *   <li>{@link io.github.atur256.webimageinterop.builtin.TriFunction}</li>
 * </ul>
 */
package io.github.atur256.webimageinterop.builtin;
