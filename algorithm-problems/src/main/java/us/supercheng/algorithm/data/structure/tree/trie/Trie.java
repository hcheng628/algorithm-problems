package us.supercheng.algorithm.data.structure.tree.trie;

import java.util.TreeMap;

public class Trie {

    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;


        Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;
    private int size;


    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getTrieSize() {
        return this.size;
    }

    public void addWord(String s) {
        // To do
    }

    public boolean contains(String s) {
        // To do
        return false;
    }

}