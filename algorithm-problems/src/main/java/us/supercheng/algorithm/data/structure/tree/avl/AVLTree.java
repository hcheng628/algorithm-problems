package us.supercheng.algorithm.data.structure.tree.avl;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {

        public K key;
        public V val;
        public Node left, right;
        public int height;

        Node(K k, V v) {
            this.key = k;
            this.val = v;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int getHeight(Node node) {
        if(node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if(node == null)
            return 0;
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    public void add(K k, V v) {
        this.root = this.add(this.root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            this.size++;
            return new Node(k , v);
        }
        if (node.key.compareTo(k) > 0)
            node.left = this.add(node.left, k, v);
        else if (node.key.compareTo(k) < 0)
            node.right = this.add(node.right, k, v);
        else
            node.val = v;

        node.height = Math.max(this.getHeight(node.left), this.getHeight(node.right)) + 1;
        int balanceFactor = this.getBalanceFactor(node);
        if(balanceFactor < -1 || balanceFactor > 1) {
            if(balanceFactor > 0) {
                if(this.getBalanceFactor(node.left) <= -1 )
                    node.left = this.doLL(node.left);
                return this.doRR(node);
            } else {
                if(this.getBalanceFactor(node.right) >= 1)
                    node.right = this.doRR(node.right);
                return this.doLL(node);
            }
        }

        return node;
    }

    public V get(K k) {
        Node node = this.get(this.root, k);
        return node == null ? null : node.val;
    }

    private Node get(Node node, K k) {
        if(node == null)
            return node;
        if(node.key.compareTo(k) > 0)
            return this.get(node.left, k);
        else if(node.key.compareTo(k) < 0)
            return this.get(node.right, k);
        else
            return node;
    }

    public void set(K k, V v) {
        Node node = this.get(this.root, k);
        if(node == null)
            throw new IllegalArgumentException("Key: " + k + " does not exist!");
        node.val = v;
    }

    public boolean contains(K k ) {
        return this.get(this.root, k) != null;
    }

    public boolean isBST() {
        List<K> list = new ArrayList();
        this.populateListInOrder(this.root, list);
        for(int i=1; i<list.size();i++)
            if(list.get(i-1).compareTo(list.get(i)) > 0)
                return false;
        return true;
    }

    private void populateListInOrder(Node node, List<K> list) {
        if(node == null)
            return;
        this.populateListInOrder(node.left, list);
        list.add(node.key);
        this.populateListInOrder(node.right, list);
    }

    public boolean isBalanced() {
        return this.isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {
        if(node == null)
            return true;

        if(Math.abs(this.getBalanceFactor(node)) >1) {
            return false;
        }

        return this.isBalanced(node.left) && this.isBalanced(node.right);
    }

    private Node doRR(Node head) {
        Node pivot = head.left;
        head.left = pivot.right;
        pivot.right = head;
        head.height = Math.max(this.getHeight(head.left), this.getHeight(head.right)) + 1;
        pivot.height = Math.max(this.getHeight(pivot.left), this.getHeight(pivot.right)) + 1;
        return pivot;
    }

    private Node doLL(Node head) {
        Node pivot = head.right;
        head.right = pivot.left;
        pivot.left = head;
        head.height = Math.max(this.getHeight(head.left), this.getHeight(head.right)) + 1;
        pivot.height = Math.max(this.getHeight(pivot.left), this.getHeight(pivot.right)) + 1;
        return pivot;
    }
}