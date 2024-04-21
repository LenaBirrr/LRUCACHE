package LABLRUCACHE.lru_cahe;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class LruCacheInvocationHandler<K,V> implements InvocationHandler{
    private LruCache<K,V> lruCache;

    public LruCacheInvocationHandler(LruCache<K,V> lruCache) {
        this.lruCache=lruCache;
    }

    private Object setElem(Method method, Object[] args)throws Throwable{
        long start = System.nanoTime();
        Object methodResult = method.invoke(lruCache, args);
        long elapsedTime = System.nanoTime() - start;
        if (methodResult == null) {
            System.out.println("Никакие элементы не удалялись. Время выполнения: " + elapsedTime);
        }
        else {
            System.out.println("Был удален элемент с ключом: "+methodResult +" Время выполнения: " + elapsedTime);
        }
        return methodResult;
    }

    private Object getElem(Method method, Object[] args)throws Throwable{
        long start = System.nanoTime();
        Object methodResult = method.invoke(lruCache, args);
        long elapsedTime = System.nanoTime() - start;
        LinkedList<K>history=lruCache.getTenRecent();
        System.out.println("Время выполнения: " + elapsedTime);
        System.out.println("История обращений:");
        for (K key:history) {
            System.out.println(key);
        }
        return methodResult;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        if (method.getName().equals("set")) {
            return setElem(method, args);
        }
        if (method.getName().equals("get")) {
            return getElem(method, args);
        }
        return method.invoke(lruCache, args);
    }
}
