package telran.set.model;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {
	private LinkedList<E>[] hashSet;
	private int size;// kol-vo elementov vsego
	private int capacity;// kol-vo prinimaemoe masivom
	private double loadFactor;

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity, double loadFactor) {
		this.hashSet = new LinkedList[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}

	public MyHashSet(int capacity) {
		this(capacity, 075);
	}

	public MyHashSet() {
		this(16, 0.75);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			int i, j, currPos, currPos2;

			@Override
			public boolean hasNext() {
				return currPos < capacity;
			}

			@Override
			public E next() {
				for (i = currPos; i < hashSet.length; i++) {
					currPos++;
					if (hashSet[i] != null) {
						for (j = currPos2; j < hashSet[i].size();) {
							if (currPos2 == hashSet[i].size()-1) {
								currPos2 = 0;
							} else {
								currPos2++;
								currPos--;
							}
							System.out.println(hashSet[i].size());
							return hashSet[i].get(j);
						}
					}
				}
				return null;
			}

		};
	}

	@Override
	public boolean add(E element) {
		if (size >= capacity * loadFactor) {
			rebuildArray();
		}
		int index = getIndex(element);
		if (hashSet[index] == null) {
			hashSet[index] = new LinkedList<>();
		}
		if (hashSet[index].contains(element)) {
			return false;
		}
		hashSet[index].add(element);
		size++;
		return false;
	}

	private void rebuildArray() {
		capacity = capacity * 2;
		LinkedList<E>[] newHeshSet = new LinkedList[capacity];
		for (int i = 0; i < hashSet.length; i++) {
			if (hashSet[i] != null) {
				for (E e : hashSet[i]) {
					int index = getIndex(e);
					if (newHeshSet[index] == null) {
						newHeshSet[index] = new LinkedList<>();
					}
					newHeshSet[index].add(e);
				}
			}
		}
		hashSet = newHeshSet;
	}

	private int getIndex(E element) {
		int hashCode = element.hashCode();
		hashCode = hashCode >= 0 ? hashCode : -hashCode;
		return hashCode % capacity;
	}

	@Override
	public boolean remove(E element) {
		int index = getIndex(element);
		if (hashSet[index] == null) {
			return false;
		}
		boolean res = hashSet[index].remove(element);
		if (res) {
			size--;
		}
		return res;
	}

	@Override
	public boolean contains(E element) {
		int index = getIndex(element);
		if (hashSet[index] == null) {
			return false;
		}
		return hashSet[index].contains(element);
	}

	@Override
	public int size() {
		return size;
	}

}
