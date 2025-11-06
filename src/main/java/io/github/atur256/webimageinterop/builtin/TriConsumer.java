package io.github.atur256.webimageinterop.builtin;

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
