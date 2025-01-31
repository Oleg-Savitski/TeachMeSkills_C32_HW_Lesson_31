package patterns.iterator.collections;

import patterns.iterator.logic.CustomIterator;

public interface CustomCollection<T> {
    CustomIterator<T> iterator();
}