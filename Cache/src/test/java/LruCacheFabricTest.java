import LABLRUCACHE.fabric.LruCacheFabric;
import LABLRUCACHE.lru_cahe.ILruCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class LruCacheFabricTest {
    @Test
    public void CreateProxyLruCache_ShouldReturnProxy() {
        // Arrange
        LruCacheFabric<Integer, String> fabric = new LruCacheFabric<>();

        // Act
        ILruCache<Integer, String> proxy = fabric.CreateProxyLruCache(10);

        // Assert
        Assertions.assertTrue(Proxy.isProxyClass(proxy.getClass()));
    }

    @Test
    public void CreateLruCache_ShouldReturnNormalLruCache() {
        // Arrange
        LruCacheFabric<Integer, String> fabric = new LruCacheFabric<>();

        // Act
        ILruCache<Integer, String> lruCache = fabric.CreateLruCache(0, 10);

        // Assert
        Assertions.assertFalse(Proxy.isProxyClass(lruCache.getClass()));
    }

    @Test
    public void CreateLruCache_ShouldReturnProxyLruCache() {
        // Arrange
        LruCacheFabric<Integer, String> fabric = new LruCacheFabric<>();

        // Act
        ILruCache<Integer, String> lruCache = fabric.CreateLruCache(1, 10);

        // Assert
        Assertions.assertTrue(Proxy.isProxyClass(lruCache.getClass()));
    }

    @Test
    public void CreateLruCache_ShouldReturnNullForUnknownType() {
        // Arrange
        LruCacheFabric<Integer, String> fabric = new LruCacheFabric<>();

        // Act
        ILruCache<Integer, String> lruCache = fabric.CreateLruCache(2, 10);

        // Assert
        Assertions.assertNull(lruCache);
    }
}
