package io.github.curryful.commons.collections;

/**
 * Extension of {@link ImmutableArrayList} that allows for mutation of the list.
 * @param <T> the type of elements in the list
 */
public class MutableArrayList<T> extends ImmutableArrayList<T> {

	protected MutableArrayList() {
		super();
	}

	/**
	 * Returns an empty {@link MutableArrayList}.
	 */
	public static <T> MutableArrayList<T> empty() {
		return new MutableArrayList<>();
	}

	/**
	 * Returns a {@link MutableArrayList} containing the elements from the specified list.
	 * @param list the list whose elements are to be put into this list
	 */
	public static <T> MutableArrayList<T> of(ImmutableArrayList<? extends T> list) {
		var mutableList = new MutableArrayList<T>();
		mutableList.addAll(list);
		return mutableList;
	}

	/**
	 * Add an element to the list.
	 * @param element the element to be added to the list
	 * @return true if the list changed as a result of the call
	 * @see ArrayList#add(Object)
	 */
	public boolean add(T element) {
		return list.add(element);
	}

	/**
	 * Add an element to the list at the specified index.
	 * @param index the index at which the specified element is to be inserted
	 * @param element the element to be added to the list
	 * @see ArrayList#add(int, Object)
	 */
	public void add(int index, T element) {
		list.add(index, element);
	}

	/**
	 * Add an element to the beginning of the list.
	 * @param element the element to be added to the list
	 * @see ArrayList#addFirst(Object)
	 */
	public void addFirst(T element) {
		list.addFirst(element);
	}

	/**
	 * Remove an element from the list.
	 * @param element the element to be removed from the list
	 * @return true if the list contained the specified element
	 * @see ArrayList#remove(Object)
	 */
	public boolean remove(T element) {
		return list.remove(element);
	}

	/**
	 * Remove the element at the specified index from the list.
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 * @see ArrayList#remove(int)
	 */
	public T remove(int index) {
		return list.remove(index);
	}

	/**
	 * Add another list's elements to this list.
	 * @param list the list whose elements are to be put into this list
	 * @return true if this list changed as a result of the call
	 * @see ArrayList#addAll(Collection)
	 */
	public boolean addAll(ImmutableArrayList<? extends T> list) {
		return this.list.addAll(list.list);
	}
}

