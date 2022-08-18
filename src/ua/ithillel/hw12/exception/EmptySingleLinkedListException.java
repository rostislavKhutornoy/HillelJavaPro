package ua.ithillel.hw12.exception;

public class EmptySingleLinkedListException extends Exception {
    public EmptySingleLinkedListException() {
        super("List is empty");
    }
}
