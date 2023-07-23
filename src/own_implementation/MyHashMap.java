package own_implementation;

public class MyHashMap<K,V> {
    // basic component
    // Node class
    // Node array
    // put
    // get
    // getIndex

    static class Node<K,V> {
        K k;
        V v;
        Node<K,V> next;

        public Node(K key, V value, Node<K,V> next) {
            this.k=key;
            this.v=value;
            this.next=next;
        }
    }

    Node<K,V>[] table;
    final int initialCapacity = 16;

    @SuppressWarnings({"unchecked"})
    public MyHashMap() {
        this.table = (MyHashMap.Node<K, V>[]) new Node[initialCapacity];
    }

    public V put(K key,V value) {
        int index = getIndex(key);
        int len = table.length;
        Node<K,V> n = table[index & (len-1)];
        Node<K,V> newNode = new Node<K,V>(key, value, null);
        if(n==null) {
            table[index & (len-1)]=newNode;
        }else {
            //condition to check existing key with current key if match do replace
            if(n.k==key || (key!=null && key.equals(n.k))) {
                n.v=value;
            }else {
                while(n.next !=null) {
                    // again check key for all next elements as well
                    if(n.next.k==key || (key!=null && key.equals(n.next.k))) {
                        n.next.v=value;
                    }
                }
                //next node came as null means last entry put node to next
                n.next=newNode;
            }
        }
        return value;
    }

    public V get(K key) {
        int index = getIndex(key);
        int len = table.length;
        Node<K,V> n = table[index & (len-1)];
        if(n != null) {
            if(n.k==key || (key!=null && key.equals(n.k))) {
                return n.v;
            }else {
                while(n.next !=null) {
                    // again check key for all next elements as well
                    if(n.next.k==key || (key!=null && key.equals(n.next.k))) {
                        return n.next.v;
                    }
                }
                //not found
                return null;
            }
        }
        return null;
    }

    public int getIndex(K key) {
        return key==null ? 0 : key.hashCode();
    }
}
