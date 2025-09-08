package builtin;

@FunctionalInterface
public interface JSFunctionInterface<T, R> {
    R apply(T arg);
}

