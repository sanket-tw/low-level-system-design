package com.caching.policy;

public interface EvictionPolicy<Key> {
    Key getKeyToRemove();

    void updateRecentKeyAccessed(Key key);
}
