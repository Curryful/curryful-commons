package io.github.curryful.commons.monads;

import java.util.function.Supplier;

public abstract class Monad<T> {

    protected T value;

    // /////////////////////////////////////////////////////////////////////////
    // Methods
    // /////////////////////////////////////////////////////////////////////////

	// TODO: Abstract map and flat map methods

	/**
	 * If a value is present, returns the value, otherwise returns the provided value.
	 * 
	 * @param other the value to be returned if there is no value present
	 * @return the value, if present, otherwise the provided value
	 */
	public T orElse(T other) {
		return hasValue() ? value : other;
	}

	/**
	 * If a value is present, returns the value, otherwise returns the value produced by the supplier.
	 * 
	 * @param supplier the supplier of the value to be returned if there is no value present
	 * @return the value, if present, otherwise the value produced by the supplier
	 */
	public T orElseGet(Supplier<? extends T> supplier) {
		return hasValue() ? value : supplier.get();
	}

    public boolean hasValue() {
        return value != null;
    }

    public T getValue() {
        return value;
    }
}

