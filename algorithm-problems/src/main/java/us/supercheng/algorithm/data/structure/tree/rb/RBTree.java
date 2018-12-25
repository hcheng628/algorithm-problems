package us.supercheng.algorithm.data.structure.tree.rb;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;

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
        return node;
    }

    private Node rotateRight(Node node) {
        Node newSubRoot = node.left;
        boolean color = node.isRedNode;
        node.isRedNode = newSubRoot.isRedNode;
        newSubRoot.isRedNode = color;
        node.left = newSubRoot.right;
        newSubRoot.right = node;
        return newSubRoot;
    }

    private Node rotateLeft(Node node) {
        Node newSubRoot = node.right;
        node.right = newSubRoot.left;
        newSubRoot.left= node;
        boolean color = node.isRedNode;
        node.isRedNode = newSubRoot.isRedNode;
        newSubRoot.isRedNode = color;
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
        else // if(key.compareTo(node.key) > 0)
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

    public static void main(String[] args){
        PrintHelper.echoLn("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            PrintHelper.echoLn("Total words: " + words.size());
            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            PrintHelper.echoLn("Total different words: " + map.getSize());
            PrintHelper.echoLn("Frequency of PRIDE: " + map.get("pride"));
            PrintHelper.echoLn("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }
}