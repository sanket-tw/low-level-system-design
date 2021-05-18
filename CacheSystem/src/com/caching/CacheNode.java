package com.caching;

public class CacheNode {

    public CacheNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    CacheNode previous;
    CacheNode next;

    String key;
    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
