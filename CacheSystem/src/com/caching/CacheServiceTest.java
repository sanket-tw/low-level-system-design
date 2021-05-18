package com.caching;

import com.caching.exception.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CacheServiceTest {

    private CacheService cacheService;

    @BeforeEach
    void setUp() {
        cacheService = new CacheService();
        cacheService.initialize(5);
    }

    @Test
    void shouldAddAndGetFromCache() {
        addRandomVal("hello");
        addRandomVal();
        addRandomVal();
        addRandomVal();
        addRandomVal();
        addRandomVal();
        addRandomVal();
        addRandomVal();
        addRandomVal();


        assertThrows(ValueNotFoundException.class, () -> cacheService.get("hello"));
    }

    private void addRandomVal(String key) {
        cacheService.add(key, UUID.randomUUID().toString());
    }

    private void addRandomVal() {
        cacheService.add(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}
