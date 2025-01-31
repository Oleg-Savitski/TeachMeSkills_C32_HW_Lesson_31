package patterns.iterator.logic;

public interface CustomIterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();
    int getPosition();
}