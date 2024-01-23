package io.github.curryful.commons;

import java.util.function.Function;

public abstract class Monad<T> {

    protected T value;

    // /////////////////////////////////////////////////////////////////////////
    // Methods
    // /////////////////////////////////////////////////////////////////////////

    public abstract <V> Monad<V> map(Function<T, V> f);

    // public abstract <V, M extends Monad<V>> M flatMap(Function<T, M> f);

    public boolean hasValue() {
        return value != null;
    }

    public T getValue() {
        return value;
    }
}
