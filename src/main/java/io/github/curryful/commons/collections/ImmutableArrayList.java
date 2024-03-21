package io.github.curryful.commons.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Wrapper for an immutable {@link ArrayList}.
 * @param <T> the type of elements in the list
 */
public class ImmutableArrayList<T> {

	protected final List<T> list = new ArrayList<>();

	protected ImmutableArrayList() {
		// noop
	}

	/**
	 * Returns an empty {@link ImmutableArrayList}.
	 */
	public static <T> ImmutableArrayList<T> empty() {
		return new ImmutableArrayList<>();
	}

	@Override
	public int hashCode() {
	    return list.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof ImmutableArrayList)) {
			return false;
		}

		return list.equals(((ImmutableArrayList<?>) other).list);
	}

	/**
	 * Returns a {@link Stream} of the elements in the list.
	 * @see ArrayList#stream()
	 */
	public Stream<T> stream() {
		return list.stream();
	}

	/**
	 * Return the number of elements in the list.
	 * @see ArrayList#size()
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Returns true if the list contains no elements.
	 * @see ArrayList#isEmpty()
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
}

