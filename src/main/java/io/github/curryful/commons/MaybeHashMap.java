package io.github.curryful.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper for {@link HashMap} to wrap value returns in {@link Maybe}s.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MaybeHashMap<K, V> {

	private final Map<K, V> map = new HashMap<>();

	public static <K, V> MaybeHashMap<K, V> empty() {
		return new MaybeHashMap<>();
	}

	public Maybe<V> get(Object key) {
		return Maybe.ofNullable(map.get(key));
	}

	public Maybe<V> put(K key, V value) {
		return Maybe.ofNullable(map.put(key, value));
	}

	public Maybe<V> remove(Object key) {
		return Maybe.ofNullable(map.remove(key));
	}

	public void putAll(MaybeHashMap<? extends K, ? extends V> maybeHashMap) {
		maybeHashMap.map.forEach((k, v) -> map.put(k, v));
	}

	public int size() {
		return map.size();
	}

	public void clear() {
		map.clear();
	}

	@Override
	public int hashCode() {
	    return map.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof MaybeHashMap)) {
			return false;
		}

		return map.equals(((MaybeHashMap<?, ?>) other).map);
	}
}

