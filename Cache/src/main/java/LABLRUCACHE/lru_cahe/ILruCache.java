package LABLRUCACHE.lru_cahe;

import java.util.LinkedList;

public interface ILruCache<K, V> {
    V get(K key);
    //возвращается значение элемента, который пришлось удалить
    V set(K key, V value);
    int getSize();
    int getLimit();
    LinkedList<K> getTenRecent();
}
