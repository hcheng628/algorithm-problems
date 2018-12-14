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
        Node curr = this.root;
        for(int i=0;i<s.length();i++) {
            char currC = s.charAt(i);
            if(!curr.next.containsKey(currC))
                curr.next.put(currC, new Node());
            curr = curr.next.get(currC);
        }
        curr.isWord = true;
        this.size++;
    }

    public boolean contains(String s) {
        Node curr = this.root;
        for(int i=0;i<s.length();i++) {
            char currC = s.charAt(i);
            if(!curr.next.containsKey(currC))
                return false;
            curr = curr.next.get(currC);
        }
        return curr.isWord;
    }
}