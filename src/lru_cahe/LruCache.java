package lru_cahe;
import java.util.HashMap;
import java.util.LinkedList;

public class LruCache<K,V> implements ILruCache<K,V>{

    class Node {
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<K, Node> map = new HashMap<K, Node>();
    Node head=null;
    Node tail=null;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return null;
    }
    @Override
    public V set(K key, V value) {
        V delval=null;
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        }else{
            Node newNode = new Node(key, value);
            if(map.size()>=capacity){
                delval=tail.value;
                map.remove(tail.key);
                delete(tail);
            }

            setHead(newNode);
            map.put(key, newNode);
        }
        return delval;
    }
    @Override
    public int getSize() {
        return map.size();
    }
    @Override
    public int getLimit() {
        return capacity;
    }

    @Override
    public LinkedList<K> getTenRecent() {
        LinkedList<K> res=new LinkedList<K>();
        Node ptr=head;
        for(int i=0;i<10&&ptr!=null;i++) {
            res.add(ptr.key);
            ptr=ptr.next;
        }
        return res;
    }

    public void delete(Node node){
        if(node.prev!=null)
            node.prev.next = node.next;
        else
            head = node.next;

        if(node.next!=null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }
    public void setHead(Node node){
        node.next = head;
        node.prev = null;

        if(head!=null)
            head.prev = node;

        head = node;

        if(tail ==null)
            tail = head;
    }

}

