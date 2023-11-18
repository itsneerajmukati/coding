import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> {

    Map<K,Node<K,V>> map;
    Node<K,V> head;
    Node<K,V> tail;
    int capacity;

    public LRU(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
        head = new Node<K,V>(null,null);
        tail = new Node<K,V>(null,null);
        head.next = tail;
        tail.prev= head;
    }

    public static void main(String[] args) throws InterruptedException{
        LRU<Integer,String> lru = new LRU<>(3);
        lru.put(1,"A");
        lru.put(2,"B");
        lru.put(3,"C");
        lru.get(1);
        lru.put(4,"D");
        lru.display(); // 4,1,3
        lru.get(2);
        lru.put(5,"E");
        lru.display(); // 5 4 1
    }

    public void display() {
        System.out.println(map);
    }

    public V get(Integer k) {
        if(map.containsKey(k)) {
            Node<K,V> node = map.get(k);
            remove(node);
            insert(node);
            return node.getValue();
        }
        return null;
    }

    public void put(K key, V value) {
        Node<K,V> node = new Node<K,V>(key,value);
        insert(node);
    }

    public void remove(Node<K,V> node) {
        map.remove(node.getKey());
        node.prev.next = node.next;
        node.next.prev= node.prev; 
    }

    public void insert(Node<K,V> node) {
        if(map.containsKey(node.getKey())) {
            remove(node);
        }
        if(map.size() == this.capacity) {
            remove(tail.prev);
        }
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev=head;
        map.put(node.getKey(),node);

    }

    


}
class Node<K,V> {
    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;
    public Node(K k, V v) {
        this.key = k;
        this.value = v;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node<K,V> [key=" + key + ", value=" + value + "]";
    }

    
    
}
