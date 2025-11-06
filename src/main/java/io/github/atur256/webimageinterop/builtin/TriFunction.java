package io.github.atur256.webimageinterop.builtin;

/**
 * Represents a function that accepts three arguments and produces a result.
 * This is a functional interface whose functional method is {@link #apply(Object, Object, Object)}.
 *
 * <p>This is the tri-arity specialization of {@link java.util.function.Function}.</p>
 *
 * @param <A> the type of the first argument
 * @param <B> the type of the second argument
 * @param <C> the type of the third argument
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface TriFunction<A, B, C, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param a the first input
     * @param b the second input
     * @param c the third input
     * @return the function result
     */
    R apply(A a, B b, C c);
}
