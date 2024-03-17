package io.github.curryful.commons.collections;

import java.util.HashMap;
import java.util.Map;

import io.github.curryful.commons.Maybe;

/**
 * Wrapper for an immutable {@link HashMap} to wrap value returns in {@link Maybe}s.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class ImmutableMaybeHashMap<K, V> {

	protected final Map<K, V> map = new HashMap<>();

	protected ImmutableMaybeHashMap() {
		// noop
	}

	/**
	 * Returns an empty {@link ImmutableMaybeHashMap}.
	 */
	public static <K, V> ImmutableMaybeHashMap<K, V> empty() {
		return new ImmutableMaybeHashMap<>();
	}

	@Override
	public int hashCode() {
	    return map.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof ImmutableMaybeHashMap)) {
			return false;
		}

		return map.equals(((ImmutableMaybeHashMap<?, ?>) other).map);
	}

	/**
     * Returns a {@link Maybe}, wrapping the value to which the specified key is mapped
	 * or an empty {@link Maybe} if this map contains no mapping for the key.
	 * @param key the key whose associated value is to be returned
	 * @see HashMap#get(Object)
	 */
	public Maybe<V> get(Object key) {
		return Maybe.ofNullable(map.get(key));
	}

	/**
	 * Return the number of key-value pairs in the map.
	 * @see HashMap#size()
	 */
	public int size() {
		return map.size();
	}
}

