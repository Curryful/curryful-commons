package io.github.curryful.commons;

import java.util.function.Function;

public class Try<T> extends Monad<T> {

    private final Throwable error;

    private Try(T value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public static <T> Try<T> success(T value) {
        return new Try<>(value, null);
    }

    public static <T> Try<T> failure(Throwable error) {
        return new Try<>(null, error);
    }

    public <V> Try<V> map(Function<T, V> f) {
        if (value == null) {
            return Try.failure(error);
        }

        return Try.success(f.apply(value));
    }

	public <V> Try<V> flatMap(Function<T, Try<V>> f) {
		if (value == null) {
			return Try.failure(error);
		}

		return f.apply(value);
	}

    public boolean isFailure() {
        return error != null;
    }

    public Throwable getError() {
        return error;
    }
}
