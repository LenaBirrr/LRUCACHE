import static org.junit.jupiter.api.Assertions.*;

import LABLRUCACHE.lru_cahe.LruCache;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class LruCacheTests {

    @Test
    void testGet() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.set(1, "value1");
        cache.set(2, "value2");

        assertEquals("value2", cache.get(2));
    }

    @Test
    void testSet() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.set(1, "value1");
        cache.set(2, "value2");
        cache.set(3, "value3");

        assertNull(cache.get(1));
        assertEquals("value3", cache.get(3));
    }

    @Test
    void testGetSize() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.set(1, "value1");
        cache.set(2, "value2");

        assertEquals(2, cache.getSize());
    }

    @Test
    void testGetLimit() {
        LruCache<Integer, String> cache = new LruCache<>(2);

        assertEquals(2, cache.getLimit());
    }

    @Test
    void testGetTenRecent() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.set(1, "value1");
        cache.set(2, "value2");
        cache.set(3, "value3");
        cache.get(2);

        LinkedList<Integer> tenRecent = cache.getTenRecent();

        assertEquals(2, tenRecent.size());
        assertEquals(2, tenRecent.get(0));
        assertEquals(3, tenRecent.get(1));
    }
}
