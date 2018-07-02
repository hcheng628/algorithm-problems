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
        if(this.root.key == null) {
            this.root.key = key;
            this.root.val = value;
            this.size++;
        } else {
            if(this.contains(key))
                this.set(key, value);
            else {
                this.add(this.root, new MyBSTMapNode<>(key, value));
                this.size++;
            }
        }
    }

    private MyBSTMapNode add(MyBSTMapNode<K, V> node, MyBSTMapNode<K,V> newNode) {
        if(node == null)
            return newNode;
        if(newNode.key.compareTo(node.key) > 0) {
            node.right = this.add(node.right, newNode);
            return node;
        }
        else {
            node.left = this.add(node.left, newNode);
            return node;
        }

    }

    @Override
    public V remove(K key) {
        MyBSTMapNode<K, V> node = this.get(this.root, key);
        if(node!= null) {
            this.root = this.removeElement(this.root, key); //???
            return node.val;
        }
        return null;
    }

    private MyBSTMapNode<K, V> removeElement(MyBSTMapNode<K, V> node, K delKey) {
        if(node == null)
            return null;

        if(node.key.compareTo(delKey) > 0) {
            node.left = this.removeElement(node.left, delKey);
            return node;
        } else if(node.key.compareTo(delKey) < 0) {
            node.right = this.removeElement(node.right, delKey);
            return node;
        } else {
            if(node.right == null) {
                MyBSTMapNode<K, V> leftC = node.left;
                node.left = null;   // ???
                this.size--;
                return leftC;
            }

            if(node.left == null) {
                MyBSTMapNode<K, V> rightC = node.right;
                node.right = null;  // ???
                this.size--;
                return rightC;
            }

            MyBSTMapNode<K, V> rightSubTreeMin = this.getMin(node.right);

            //MyBSTMapNode<K, V> rightSubTreeMin = this.removeMinElement(node.right);
            //rightSubTreeMin.right = node.right;
            rightSubTreeMin.right = this.removeMinElement(node.right);
            rightSubTreeMin.left = node.left;
            node.right = node.left = null;
            return rightSubTreeMin;
        }
    }

    private MyBSTMapNode<K, V> removeMinElement(MyBSTMapNode<K, V> currNode) {
        if(currNode.left == null) {
            this.size--;
            if(currNode.right == null)
                return null;
            else
                return currNode.right;
        }
        currNode.left = this.removeMinElement(currNode.left);
        return currNode;    // ???
    }

    @Override
    public boolean contains(K key) {
        if(this.isEmpty())
            return false;

        MyBSTMapNode node = this.get(this.root, key);
        if(node == null)
            return false;

        return true;
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



    public V getMax() {
        if(this.isEmpty())
            return null;
        return this.getMax(this.root).val;
    }

    private MyBSTMapNode<K, V> getMax(MyBSTMapNode<K, V> node) {
        while (node.right != null)
            node = node.right;
        return node;
    }


    public V getMin() {
        if(this.isEmpty())
            return null;
        return this.getMin(this.root).val;
    }

    private MyBSTMapNode<K,V> getMin(MyBSTMapNode<K, V> node) {
        while(node.left != null)
            node = node.left;
        return node;
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