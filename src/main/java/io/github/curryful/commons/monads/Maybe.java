package io.github.curryful.commons.monads;

import java.util.Optional;
import java.util.function.Function;

public class Maybe<T> extends Monad<T> {

    private Maybe(T value) {
        this.value = value;
    }

    public static <T> Maybe<T> just(T value) {
        return new Maybe<>(value);
    }

    public static <T> Maybe<T> none() {
        return new Maybe<>(null);
    }

    public static <T> Maybe<T> ofNullable(T nullable) {
        return new Maybe<>(nullable);
    }

    public static <T> Maybe<T> from(Optional<T> optional) {
        return optional.map(Maybe::just).orElse(Maybe.none());
    }

    public <V> Maybe<V> map(Function<T, V> f) {
        if (!hasValue()) {
            return Maybe.none();
        }

        return Maybe.ofNullable(f.apply(value));
    }

    public <V> Maybe<V> flatMap(Function<T, Maybe<V>> f) {
        if (!hasValue()) {
            return Maybe.none();
        }

        return f.apply(value);
    }
}

