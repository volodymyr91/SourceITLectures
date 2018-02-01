package homework;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList<T> implements MyList, Iterable<Object> {
	private int size = 0;
	private Object[] elementData = new Object[10];

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(Object e) {
		if (size + 1 >= elementData.length) {
			elementData = Arrays.copyOf(elementData, elementData.length * 3 / 2 + 1);
		}
		elementData[size++] = e;
	}

	@Override
	public void clear() {
		// let GC do its work
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			return false;
		}

		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				System.arraycopy(elementData, i + 1, elementData, i, size - i);
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < elementData.length; i++) {
			if (o == elementData[i])
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		Object[] comparedList = c.toArray();
		for (int i = 0; i < c.size(); i++) {
			if (!this.contains(comparedList[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < size; i++) {
			sb.append("[" + elementData[i].toString() + "]");
			if (!(i == size - 1)) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
		// return Arrays.toString(elementData);
	}

	@Override
	public java.util.Iterator<Object> iterator() {
		return new IteratorImlp();
	}

	private class IteratorImlp implements Iterator<Object> {
		private int cursor = 0;
		private int lastReturned = -1;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public Object next() {
			try {
				int i = cursor;
				Object next = elementData[i];
				lastReturned = i;
				cursor++;
				return next;
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (lastReturned < 0) {
				throw new IllegalStateException();
			}
			try {
				DefaultMyList.this.remove(elementData[lastReturned]);
				if (lastReturned < cursor) {
					cursor--;
				}
				lastReturned = -1;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}
	}

}
