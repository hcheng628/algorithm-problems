package us.supercheng.algorithm.data.structure.tree.rb;

public class RBTree<K extends Comparable<K>, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean isRedNode;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.isRedNode = RED;
        }
    }

    private Node root;
    private int size;
    private static boolean RED = true,
                           BLACK = false;

    public RBTree(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void add(K key, V value) {
        this.root = add(this.root, key, value);
        if(this.root.isRedNode != BLACK)
            this.root.isRedNode = BLACK;
    }

    private Node add(Node node, K key, V value){
        if(node == null){
            this.size ++;
            return new Node(key, value);
        }


        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

        if(this.isRedNode(node.right) && !this.isRedNode(node.left))
            node = this.rotateLeft(node);

        if(this.isRedNode(node.left) && this.isRedNode(node.left.left))
            node = this.rotateRight(node);

        if(this.isRedNode(node.left) && this.isRedNode(node.right))
            node = this.flipColors(node);

        return node;
    }

    private Node rotateLeft(Node node) {
        Node newSubRoot = node.right;
        node.right = newSubRoot.left;
        newSubRoot.left= node;

        newSubRoot.isRedNode = node.isRedNode;
        node.isRedNode = RED;
        return newSubRoot;
    }

    private Node rotateRight(Node node) {
        Node newSubRoot = node.left;
        node.left = newSubRoot.right;
        newSubRoot.right = node;

        newSubRoot.isRedNode = node.isRedNode;
        node.isRedNode = RED;
        return newSubRoot;
    }

    private Node flipColors(Node node) {
        if(!node.isRedNode)
            node.isRedNode = RED;
        if(node.left.isRedNode)
            node.left.isRedNode = BLACK;
        if(node.right.isRedNode)
            node.right.isRedNode = BLACK;
        return node;
    }

    private boolean isRedNode(Node node) {
        return node != null && node.isRedNode;
    }

    private Node getNode(Node node, K key){
        if(node == null)
            return null;
        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(this.root, key) != null;
    }

    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key){
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
}