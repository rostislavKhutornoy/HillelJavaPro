package ua.ithillel.hw12.collection;

import ua.ithillel.hw12.unit.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedListIterator<T> implements Iterator<T> {
    private final Node<T> current;

    public SingleLinkedListIterator(SingleLinkedList<T> list) {
        this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException();
        } else {
            return current.getNext().getData();
        }
    }
}
