package us.supercheng.algorithm.data.structure.map;

public class MyLinkedListMap<K, V> implements Map<K, V> {

    private MyLinkedListNode<K, V> node;
    private MyLinkedListNode<K, V> dummy;
    private int size;

    public MyLinkedListMap() {
        this.node = new MyLinkedListNode<>();
        this.dummy = new MyLinkedListNode<>();
    }

    @Override
    public void add(K key, V value) {
        if(this.isEmpty()) {
            this.node.key = key;
            this.node.val = value;
            this.dummy.next = this.node;
            this.size++;
        } else {
            if(this.contains(key))
                this.set(key, value);
            else {
                this.dummy.next = new MyLinkedListNode<>(key, value, this.dummy.next);
                this.size++;
            }
        }
    }

    @Override
    public V remove(K key) {
        MyLinkedListNode<K, V> curr = this.dummy;
        MyLinkedListNode<K, V> ret;
        while (curr.next != null) {
            if(curr.next.key.equals(key)) {
                ret = curr.next;
                curr.next = curr.next.next;
                ret.next = null;
                this.size--;
                return ret.val;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        MyLinkedListNode curr = this.dummy;
        while(curr.next != null) {
            curr = curr.next;
            if(curr.key.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        MyLinkedListNode<K, V> curr = this.dummy;
        while (curr.next != null) {
            curr = curr.next;
            if(curr.key.equals(key))
                return curr.val;
        }
        return null;
    }

    private MyLinkedListNode<K, V> getNode(K key) {
        MyLinkedListNode<K, V> curr = this.dummy;
        while (curr.next != null) {
            curr = curr.next;
            if(curr.key.equals(key))
                return curr;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        MyLinkedListNode<K, V> node = this.getNode(key);
        if(node == null)
            throw new IllegalArgumentException("Key: " + key + " does not exist in the map");
        node.val = newValue;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}