package com.company.iterator;

public interface Iterator<T> {
    void next();
    T current();
    boolean isValid();
    boolean isLast();
}
