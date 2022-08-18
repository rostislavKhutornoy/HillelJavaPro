package ua.ithillel.hw12.collection;

import ua.ithillel.hw12.exception.EmptySingleLinkedListException;
import ua.ithillel.hw12.unit.Node;

public class SingleLinkedList<T> {
    private Node<T> head;

    public SingleLinkedList() {
        head = null;
    }

    public SingleLinkedList(T value) {
        if (value != null) {
            head = new Node<>(value, null);
        } else {
            head = null;
        }
    }

    public SingleLinkedList(T[] array) {
        for (T t : array) {
            insertLast(t);
        }
    }

    public void insertFirst(T data) {
        head = new Node<>(data, head);
    }

    public void insertLast(T data) {
        if (!isEmpty()) {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(data, null));
        } else {
            insertFirst(data);
        }
    }

    public void deleteFirst() throws EmptySingleLinkedListException {
        if (!isEmpty()) {
            head = head.getNext();
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
                        T firstData = getByIndex(firstIndex).getData();
                        T secondData = getByIndex(secondIndex).getData();
                        getByIndex(firstIndex).setData(secondData);
                        getByIndex(secondIndex).setData(firstData);
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
        if (isEmpty()) {
            return 0;
        } else {
            int length = 0;
            Node<T> current = head;
            while (current != null) {
                length++;
                current = current.getNext();
            }
            return length;
        }
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