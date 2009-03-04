package org.exigencecorp.assertions;

import java.util.List;

public class ListAsserter<T> extends ObjectAsserter<List<T>> {

    public ListAsserter(List<T> list) {
        super(list);
    }

    public void contains(T element) {
        if (!this.object.contains(element)) {
            throw new RuntimeException("failed");
        }
    }

}
