package com.caching.storage;

import com.caching.exception.StorageFullException;
import com.caching.exception.ValueNotFoundException;

import java.util.HashMap;

public class HashMapBasedStorageSystem implements StorageSystem<String, String> {

    private final int size;
    private HashMap<String, String> memory;


    public HashMapBasedStorageSystem(int size) {
        this.memory = new HashMap<>();
        this.size = size;
    }

    @Override
    public void add(String k, String v) throws StorageFullException {
        if (isFull()) {
            throw new StorageFullException("Storage is full");
        }
        memory.put(k, v);
    }

    private boolean isFull() {
        return this.memory.size() >= size;
    }

    @Override
    public String get(String k) throws ValueNotFoundException {
        if (memory.containsKey(k))
            return memory.get(k);
        else
            throw new ValueNotFoundException();
    }

    @Override
    public void evict(String key) {
        memory.remove(key);
    }
}
