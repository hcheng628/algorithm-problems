package us.supercheng.algorithm.data.structure.map;

import us.supercheng.algorithm.common.helper.PrintHelper;

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
        MyBSTMapNode<K, V> ret = this.removeElement(this.root, key);
        PrintHelper.echoLn(ret.val);
        return ret != null ? ret.val : null;
    }

    private MyBSTMapNode<K, V> removeElement(MyBSTMapNode<K, V> node, K delKey) {
        if(node == null)
            return null;

        if(node.key.compareTo(delKey) > 0) {
            node.left = this.removeElement(node.left, delKey);
        } else if(node.key.compareTo(delKey) < 0) {
            node.right = this.removeElement(node.right, delKey);
        } else {
            if(node.right == null && node.left == null) {
                return null;
            } else if (node.right != null && node.left == null) {
                return node.right;
            } else if (node.right == null && node.left != null) {
                return node.left;
            } else {
                MyBSTMapNode<K, V> minNode = this.removeMinElement(node.left, this.getMin(node.left).key);
                minNode.left = node.left;
                minNode.right = node.right;
                this.size--;
                return node;
            }
        }
        return node;
    }

    public V removeMinElement() {
        MyBSTMapNode<K, V> retNode = this.getMin(this.root);
        this.removeMinElement(this.root, retNode.key);
        return retNode.val;
    }

    public V removeMaxElement() {
        MyBSTMapNode<K, V> retNode = this.getMax(this.root);
        this.removeMaxElement(this.root, retNode.key);
        return retNode.val;
    }

    private MyBSTMapNode<K, V> removeMinElement(MyBSTMapNode<K, V> currNode, K delKey) {
        PrintHelper.echoLn("In CurrNode: " + currNode.val + " key: " + delKey);
        MyBSTMapNode<K, V> parentDelNode = currNode;
        while(parentDelNode.left != null) {
            if(parentDelNode.key.equals(delKey))
                break;
            parentDelNode = parentDelNode.left;
        }
        MyBSTMapNode delNode = parentDelNode.left;
        PrintHelper.echoLn("parentDelNode: " + parentDelNode.val);
        PrintHelper.echoLn("parentDelNode Left: " + parentDelNode.left);
        PrintHelper.echoLn("parentDelNode Right: " + parentDelNode.right);

        if(delNode.right != null)
            parentDelNode.left = delNode.right;
        else
            parentDelNode.left = null;
        this.size--;
        /**/

        return delNode;
    }


    private MyBSTMapNode<K, V> removeMaxElement(MyBSTMapNode<K, V> currNode, K delKey) {
        MyBSTMapNode<K, V> parentDelNode = currNode;
        while(parentDelNode.right != null) {
            if(parentDelNode.key.equals(delKey))
                break;
            parentDelNode = parentDelNode.right;
        }
        MyBSTMapNode delNode = parentDelNode.right;
        if(delNode.left != null)
            parentDelNode.right = delNode.left;
        else
            parentDelNode.right = null;
        this.size--;
        return delNode;
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

    private MyBSTMapNode<K, V> getMax(MyBSTMapNode<K, V> node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public V getMax() {
        if(this.isEmpty())
            return null;
        return this.getMax(this.root).val;
    }

    private MyBSTMapNode<K,V> getMin(MyBSTMapNode<K, V> node) {
        while(node.left != null)
            node = node.left;
        return node;
    }

    public V getMin() {
        if(this.isEmpty())
            return null;
        return this.getMin(this.root).val;
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