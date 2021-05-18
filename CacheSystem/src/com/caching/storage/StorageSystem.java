package com.caching.storage;

import com.caching.exception.StorageFullException;
import com.caching.exception.ValueNotFoundException;

public interface StorageSystem<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws ValueNotFoundException;

    void evict(Key key);
}
