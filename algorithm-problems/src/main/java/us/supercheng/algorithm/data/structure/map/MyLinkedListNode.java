package us.supercheng.algorithm.data.structure.map;

public class MyLinkedListNode<K, V> {

    public K key;
    public V val;
    public MyLinkedListNode<K, V> next;

    public MyLinkedListNode() {
        this(null, null, null);
    }

    public MyLinkedListNode(K k, V v) {
        this(k, v, null);
    }

    public MyLinkedListNode(K k, V v, MyLinkedListNode<K, V> n) {
        this.key = k;
        this.val = v;
        this.next = n;
    }
}