package org.exigencecorp.avow;

import java.util.List;

public class ListAsserter<T> extends ObjectAsserter<List<T>> {

	public ListAsserter(List<T> list) {
		super(list);
	}

	public void size(int i) {
		if (this.object.size() != i) {
			throw new RuntimeException("failed");
		}
	}

	public void contains(T element) {
		if (!this.object.contains(element)) {
			throw new RuntimeException("failed");
		}
	}

}
