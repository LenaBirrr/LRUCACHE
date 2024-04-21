package LABLRUCACHE.fabric;

import LABLRUCACHE.lru_cahe.LruCache;
import LABLRUCACHE.lru_cahe.LruCacheInvocationHandler;
import LABLRUCACHE.lru_cahe.ILruCache;

import java.lang.reflect.Proxy;

public class LruCacheFabric<K, V> {
    public ILruCache<K,V> CreateProxyLruCache(int capacity) {
        LruCache<K, V> lruCache = new LruCache<>(capacity);
        ClassLoader lruCacheClassLoader = lruCache.getClass().getClassLoader();
        Class[] interfaces = lruCache.getClass().getInterfaces();
        return (ILruCache<K,V>) Proxy.newProxyInstance(lruCacheClassLoader,
                interfaces,
                new LruCacheInvocationHandler<>(lruCache));
    }

    public ILruCache<K,V> CreateLruCache(int lruCacheType, int capacity) {
        switch (lruCacheType) {
            case 0 -> {
                return new LruCache<>(capacity);
            }
            case 1 -> {
                return CreateProxyLruCache(capacity);
            }
        }
        return null;
    }
}
