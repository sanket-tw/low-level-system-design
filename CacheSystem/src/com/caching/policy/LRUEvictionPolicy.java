package com.caching.policy;

import com.caching.policy.internal.DoublyLinkedList;

import java.security.Key;
import java.util.HashMap;

public class LRUEvictionPolicy implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> doublyLinkedList;
    private HashMap<Key, DoublyLinkedList<Key>> doublyLinkedListHashMap;

    @Override
    public Key getKeyToRemove() {
        Key key = doublyLinkedList.removeFromFirst();
        if (key == null) return null;
        doublyLinkedListHashMap.remove(key);
        return key;
    }

    @Override
    public void updateRecentKeyAccessed(Key key) {
        if (doublyLinkedListHashMap.containsKey(key)) {
            DoublyLinkedList<Key> node = doublyLinkedListHashMap.get(key);
            doublyLinkedList.detachNode(node);
            doublyLinkedList.addNodeAtLast(node);
        } else {
            DoublyLinkedList<Key> node = new DoublyLinkedList<>(key);
            doublyLinkedList.addNodeAtLast(node);
            doublyLinkedListHashMap.put(key, node);
        }
    }
}
