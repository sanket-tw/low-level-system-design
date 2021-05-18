package com.caching.storage;

import com.caching.CacheNode;
import com.caching.exception.ValueNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class OldImplCache {

    public OldImplCache(int capacity) {
        this.capacity = capacity;
        this.recentList = new CacheNode("1", "value");
        this.end = recentList;
        this.memory = new HashMap<>() {
            {
                put("1", recentList);
            }
        };
    }

    private Map<String, CacheNode> memory;

    private CacheNode recentList;

    private CacheNode end;

    private int capacity;

    public String get(String key) throws ValueNotFoundException {
        if (!memory.containsKey(key))
            throw new ValueNotFoundException("value not set or is evicted");
        CacheNode cacheNode = memory.get(key);
        removeNode(cacheNode);
        updateHead(cacheNode);
        return cacheNode.getValue();
    }

    public void addToCache(String key, String value) {
        if (memory.size() >= capacity)
            evict(); //can throw storage full exception
        CacheNode cacheNode;
        if (memory.containsKey(key)) {
            cacheNode = memory.get(key);
            removeNode(cacheNode);
        } else {
            cacheNode = new CacheNode(key, value);
        }
        updateHead(cacheNode);
        memory.put(key, cacheNode);
    }

    private void updateHead(CacheNode cacheNode) {
        cacheNode.next = recentList;
        recentList.previous = cacheNode;
        this.recentList = cacheNode;
    }

    private void removeNode(CacheNode cacheNode) {
        if (this.recentList.equals(cacheNode))
            return;
        CacheNode prev = cacheNode.previous;
        CacheNode next = cacheNode.next;
        prev.next = next;
        if (next != null)
            next.previous = prev;
    }

    public void evict() {
        memory.remove(end.getKey());
        CacheNode newEnd = end.previous;
        end.previous.next = null;
        end.previous = null;
        this.end = newEnd;
    }
}
