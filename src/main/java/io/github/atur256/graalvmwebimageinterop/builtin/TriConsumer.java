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
package io.github.atur256.graalvmwebimageinterop.builtin;

/**
 * Represents an operation that accepts three input arguments and returns no result.
 * This is a functional interface whose functional method is {@link #accept(Object, Object, Object)}.
 *
 * <p>This is the tri-arity specialization of {@link java.util.function.Consumer}.</p>
 *
 * @param <A> the type of the first argument
 * @param <B> the type of the second argument
 * @param <C> the type of the third argument
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param a the first input
     * @param b the second input
     * @param c the third input
     */
    void accept(A a, B b, C c);
}
