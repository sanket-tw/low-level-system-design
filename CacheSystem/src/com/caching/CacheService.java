package com.caching;

import com.caching.exception.StorageFullException;
import com.caching.exception.ValueNotFoundException;
import com.caching.policy.EvictionPolicy;
import com.caching.storage.HashMapBasedStorageSystem;
import com.caching.storage.StorageSystem;

public class CacheService<Key, Value> {

    private final StorageSystem<Key, Value> storageSystem;
    private final EvictionPolicy<Key> evictionPolicy;

    public CacheService(StorageSystem<Key, Value> storageSystem, EvictionPolicy<Key> evictionPolicy) {
        this.storageSystem = storageSystem;
        this.evictionPolicy = evictionPolicy;
    }

    public void add(Key key, Value value) {
        try {
            storageSystem.add(key, value);
            evictionPolicy.updateRecentKeyAccessed(key);
        } catch (StorageFullException e) {
            //try evict
            Key removeKey = evictionPolicy.getKeyToRemove();
            storageSystem.evict(removeKey);
            add(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storageSystem.get(key);
            evictionPolicy.updateRecentKeyAccessed(key);
            return value;
        } catch (ValueNotFoundException e) {
            System.out.println("value not found");
            return null;
        }
    }
}
