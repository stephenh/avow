package org.exigencecorp.avow;

import junit.framework.ComparisonFailure;

public class StringAsserter extends ObjectAsserter<String> {

    public StringAsserter(String object) {
        super(object);
    }

    public void equals(String other) {
        if (this.object == null || !this.object.equals(other)) {
            throw new ComparisonFailure(null, other, this.object);
        }
    }

}
