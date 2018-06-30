package us.supercheng.algorithm.data.structure.map;

public class MyBSTMapNode<K, V> {

    public K key;
    public V val;
    public MyBSTMapNode<K, V> left;
    public MyBSTMapNode<K, V> right;

    public MyBSTMapNode(K k, V v, MyBSTMapNode<K, V> l, MyBSTMapNode<K, V> r) {
        this.key = k;
        this.val = v;
        this.left = l;
        this.right = r;
    }

    public MyBSTMapNode(K k, V v) {
        this(k, v, null, null);
    }

    public MyBSTMapNode() {
        this(null, null, null, null);
    }
}