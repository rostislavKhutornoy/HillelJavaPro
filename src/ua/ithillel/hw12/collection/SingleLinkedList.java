package ua.ithillel.hw12.collection;

import ua.ithillel.hw12.exception.EmptySingleLinkedListException;
import ua.ithillel.hw12.unit.Node;

public class SingleLinkedList<T> {
    private Node<T> head;
    private int length;
    public SingleLinkedList() {
        head = null;
        length = 0;
    }

    public SingleLinkedList(T value) {
        if (value != null) {
            length = 1;
            head = new Node<>(value, null);
        } else {
            head = null;
        }
    }

    public SingleLinkedList(T[] array) {
        length = 0;
        for (T t : array) {
            insertLast(t);
        }
    }

    public void insertFirst(T data) {
        head = new Node<>(data, head);
        length++;
    }

    public void insertLast(T data) {
        if (!isEmpty()) {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(data, null));
            length++;
        } else {
            insertFirst(data);
        }
    }

    public void deleteFirst() throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            head = head.getNext();
            length--;
        } else {
            throw new EmptySingleLinkedListException();
        }
    }

    public void deleteLast() throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            Node<T> current = head;
            Node<T> temp = head;
            while (current.getNext() != null) {
                temp = current;
                current = current.getNext();
            }
            current = temp;
            current.setNext(null);
            length--;
        } else {
            throw new EmptySingleLinkedListException();
        }
    }

    public void insertByIndex(int index, T data) throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            if (index >= 0 && index < length()) {
                if (index == 0) {
                    insertFirst(data);
                } else {
                    Node<T> temp = getByIndex(index);
                    getByIndex(index - 1).setNext(new Node<>(data, temp));
                    length++;
                }
            } else {
                throw new IndexOutOfBoundsException(index);
            }
        } else {
            throw new EmptySingleLinkedListException();
        }
    }

    public void deleteByIndex(int index) throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            if (index >= 0 && index < length()) {
                if (index == 0) {
                    deleteFirst();
                } else if (index == length() - 1) {
                    deleteLast();
                } else {
                    getByIndex(index - 1).setNext(getByIndex(index - 1).getNext().getNext());
                    length--;
                }
            } else {
                throw new IndexOutOfBoundsException(index);
            }
        } else {
            throw new EmptySingleLinkedListException();
        }
    }

    public void swap(int firstIndex, int secondIndex) throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            if (firstIndex >= 0 && firstIndex < length()) {
                if (secondIndex >= 0 && secondIndex < length()) {
                    if (firstIndex != secondIndex) {
                        Node<T> node1 = getByIndex(firstIndex);
                        Node<T> node2 = getByIndex(secondIndex);
                        if (node1 == null || node2 == null) return;
                        Node<T> node1Prev = getByIndex(firstIndex - 1);
                        Node<T> node2Prev = getByIndex(secondIndex - 1);
                        if (node1Prev.getNext() == null || node2Prev.getNext() == null) return;
                        if (node2Prev.equals(node1)) {
                            node1.setNext(node2.getNext());
                            node2.setNext(node1);
                            node1Prev.setNext(node2);
                        } else if (node1Prev.equals(node2)) {
                            node2.setNext(node1.getNext());
                            node1.setNext(node2);
                            node2Prev.setNext(node1);
                        } else {
                            Node<T> tmp = node1.getNext();
                            node1.setNext(node2.getNext());
                            node2.setNext(tmp);
                            node1Prev.setNext(node2);
                            node2Prev.setNext(node1);
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException(secondIndex);
                }
            } else {
                throw new IndexOutOfBoundsException(firstIndex);
            }
        } else {
            throw new EmptySingleLinkedListException();
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private Node<T> getByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
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
}