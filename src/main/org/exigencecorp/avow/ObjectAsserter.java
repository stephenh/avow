package org.exigencecorp.avow;

public class ObjectAsserter<T> {

    protected final T object;

    public ObjectAsserter(T object) {
        this.object = object;
    }

    public void equals(T other) {
        if (this.object == null || !this.object.equals(other)) {
            throw new RuntimeException("Expected '" + other + "' but was '" + this.object + "'");
        }
    }
    
    public void notEquals(T other) {
        if (this.object == null || this.object.equals(other)) {
            throw new RuntimeException("Expected '" + other + "' but was '" + this.object + "'");
        }
    }

    public void is(Object other) {
        if (this.object != other) {
            throw new RuntimeException();
        }
    }
    
    public void isNull() {
    	if (this.object != null) {
            throw new RuntimeException();
    	}
    }
}
