package io.github.curryful.commons.monads;

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

    public boolean hasValue() {
        return value != null;
    }

    public T getValue() {
        return value;
    }
}

