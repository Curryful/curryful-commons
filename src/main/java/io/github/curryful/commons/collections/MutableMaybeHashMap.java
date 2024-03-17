package io.github.curryful.commons.collections;

import io.github.curryful.commons.Maybe;

/**
 * Extension of {@link ImmutableMaybeHashMap} that allows for mutation of the map.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MutableMaybeHashMap<K, V> extends ImmutableMaybeHashMap<K, V> {

	protected MutableMaybeHashMap() {
		super();
	}

	/**
	 * Returns an empty {@link MutableMaybeHashMap}.
	 */
	public static <K, V> MutableMaybeHashMap<K, V> empty() {
		return new MutableMaybeHashMap<>();
	}

	/**
	 * Returns a {@link MutableMaybeHashMap} containing the key-value pairs from the specified map.
	 * @param maybeHashMap the map whose key-value pairs are to be put into this map
	 */
	public static <K, V, M extends ImmutableMaybeHashMap<? extends K, ? extends V>> MutableMaybeHashMap<K, V> of(M maybeHashMap) {
		var mutableMap = new MutableMaybeHashMap<K, V>();
		mutableMap.putAll(maybeHashMap);
		return mutableMap;
	}

	/**
	 * Put a key-value pair into the map, returning an {@link Maybe} wrapping the value previously
	 * associated with the key or an empty {@link Maybe} if there was no previously associated value.
	 * @param key the key with which the specified value is to be associated 
	 * @param value the value to be associated with the specified key
	 * @see HashMap#put(Object, Object)
	 */
	public Maybe<V> put(K key, V value) {
		return Maybe.ofNullable(map.put(key, value));
	}

	/**
	 * Remove a key-value pair from the map, returning an {@link Maybe} wrapping the value previously
	 * associated with the key or an empty {@link Maybe} if there was no previously associated value.
	 * @param key the key whose mapping is to be removed from the map
	 * @see HashMap#remove(Object)
	 */
	public Maybe<V> remove(Object key) {
		return Maybe.ofNullable(map.remove(key));
	}

	/**
	 * Put another map's key-value pairs into this map.
	 * @param maybeHashMap the map whose key-value pairs are to be put into this map
	 * @see HashMap#putAll(Map)
	 */
	public <M extends ImmutableMaybeHashMap<? extends K, ? extends V>> void putAll(M maybeHashMap) {
		maybeHashMap.map.forEach((k, v) -> map.put(k, v));
	}
}

