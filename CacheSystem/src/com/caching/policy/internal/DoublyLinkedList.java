package com.caching.policy.internal;

public class DoublyLinkedList<Key> {

    private DoublyLinkedList<Key> next;
    private DoublyLinkedList<Key> previous;
    private Key key;

    public DoublyLinkedList(Key key) {
        this.key = key;
    }
}
