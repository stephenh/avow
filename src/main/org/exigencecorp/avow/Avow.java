package org.exigencecorp.avow;

import java.util.List;

import junit.framework.AssertionFailedError;

public class Avow {

    public static <T> ObjectAsserter<T> that(T o) {
        return new ObjectAsserter<T>(o);
    }

    public static <T> ListAsserter<T> that(List<T> list) {
        return new ListAsserter<T>(list);
    }

    public static StringAsserter that(String o) {
        return new StringAsserter(o);
    }

    public static void fail() {
        throw new AssertionFailedError(null);
    }
}
