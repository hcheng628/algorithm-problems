package us.supercheng.algorithm.data.structure.map;

public class MyBSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private MyBSTMapNode<K, V> root;
    private int size;

    public MyBSTMap() {
        this.root = new MyBSTMapNode();
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        if(this.root.key == null && this.root.key == null &&
                this.root.left == null && this.root.right == null) {
            this.root.key = key;
            this.root.val = value;
            this.size++;
        } else {
            if(this.contains(key))
                this.set(key, value);
            else {
                this.add(this.root, new MyBSTMapNode<K, V>(key, value));
                this.size++;
            }
        }
    }

    private MyBSTMapNode add(MyBSTMapNode<K, V> node, MyBSTMapNode<K,V> newNode) {
        if(node == null)
            return newNode;
        if(newNode.key.compareTo(node.key) > 0)
            return node.right = this.add(node.right, newNode);
        else
            return node.left = this.add(node.left, newNode);
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) == null ? false : true;
    }

    @Override
    public V get(K key) {
        MyBSTMapNode<K, V> node = this.get(this.root, key);
        return node == null ? null : node.val;
    }

    private MyBSTMapNode get(MyBSTMapNode<K, V> node, K k) {
        if(node == null)
            return null;
        if(node.key.equals(k))
            return node;
        else if(k.compareTo(node.key) > 0)
            return this.get(node.right, k);
        else
            return this.get(node.left, k);
    }

    @Override
    public void set(K key, V newValue) {
        MyBSTMapNode<K, V> node = this.get(this.root, key);
        if(node == null)
            throw new RuntimeException("Cannot Set New Value for Not Existing Key: " + key + "");
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