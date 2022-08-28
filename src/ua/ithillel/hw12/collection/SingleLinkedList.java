package ua.ithillel.hw12.collection;

import ua.ithillel.hw12.exception.EmptySingleLinkedListException;
import ua.ithillel.hw12.unit.Node;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;
    public SingleLinkedList() {
    }

    public SingleLinkedList(T value) {
        if (value != null) {
            size = 1;
            head = new Node<>(value, null);
        }
    }

    public SingleLinkedList(T[] array) {
        for (T t : array) {
            insertLast(t);
        }
    }

    public void insertFirst(T data) {
        head = new Node<>(data, head);
        size++;
    }

    public void insertLast(T data) {
        if (head != null) {
            getByIndex(size - 1).setNext(new Node<>(data, null));
            size++;
        } else {
            insertFirst(data);
        }
    }

    public void deleteFirst() throws EmptySingleLinkedListException {
        checkEmptiness();
        head = head.getNext();
        size--;
    }

    public void deleteLast() throws EmptySingleLinkedListException {
        checkEmptiness();
        if (size > 1) {
            getByIndex(size - 2).setNext(null);
            size--;
        } else {
            deleteFirst();
        }
    }

    public void insertByIndex(int index, T data) throws EmptySingleLinkedListException {
        checkEmptiness();
        checkIndexCorrectness(index);
        if (index == 0) {
            insertFirst(data);
        } else {
            Node<T> temp = getByIndex(index);
            getByIndex(index - 1).setNext(new Node<>(data, temp));
            size++;
        }
    }

    public void deleteByIndex(int index) throws EmptySingleLinkedListException {
        checkEmptiness();
        checkIndexCorrectness(index);
        if (index == 0) {
            deleteFirst();
        } else if (index == size() - 1) {
            deleteLast();
        } else {
            getByIndex(index - 1).setNext(getByIndex(index - 1).getNext().getNext());
            size--;
        }
    }

    public void swap(int firstIndex, int secondIndex) throws EmptySingleLinkedListException {
        checkEmptiness();
        checkIndexCorrectness(firstIndex);
        checkIndexCorrectness(secondIndex);
        if (firstIndex != secondIndex) {
            Node<T> firstIndexNode = getByIndex(firstIndex);
            Node<T> secondIndexNode = getByIndex(secondIndex);
            if (size == 2) {
                firstIndexNode.setNext(null);
                secondIndexNode.setNext(firstIndexNode);
                head = secondIndexNode;
            } else if (firstIndex == 0) {
                Node<T> temp = firstIndexNode.getNext();
                getByIndex(secondIndex - 1).setNext(firstIndexNode);
                firstIndexNode.setNext(secondIndexNode.getNext());
                head = secondIndexNode;
                secondIndexNode.setNext(temp);
            } else if (secondIndex == 0) {
                Node<T> temp = secondIndexNode.getNext();
                getByIndex(firstIndex - 1).setNext(secondIndexNode);
                secondIndexNode.setNext(firstIndexNode.getNext());
                head = firstIndexNode;
                firstIndexNode.setNext(temp);
            } else {
                Node<T> temp = firstIndexNode.getNext();
                firstIndexNode.setNext(secondIndexNode.getNext());
                secondIndexNode.setNext(temp);
                getByIndex(firstIndex - 1).setNext(secondIndexNode);
                getByIndex(secondIndex - 1).setNext(firstIndexNode);
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object[] toArray() {
        Object[] objects = new Object[size];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = getByIndex(i).getData();
        }
        return objects;
    }

    private Node<T> getByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private void checkEmptiness() throws EmptySingleLinkedListException {
        if (head == null) {
            throw new EmptySingleLinkedListException();
        }
    }

    private void checkIndexCorrectness(int index) {
        if (!(index >= 0 && index < size())) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public String toString() {
        String str = "SingleLinkedList [ ";
        Node<T> current = head;
        while (current != null) {
            if (current.getNext() == null) {
                str += current.getData().toString();
            } else {
                str += current.getData().toString() + ", ";
            }
            current = current.getNext();
        }
        str += " ]";
        return str;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<>(this);
    }
}