package us.supercheng.algorithm.problems.implementtrieprefixtree;

class Trie {

    private class Node{

        boolean isWord;
        Node [] next;

        public Node() {
            this.next = new Node [26];
        }

    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = this.root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(curr.next[index] == null)
                curr.next[index] = new Node();
            curr = curr.next[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = this.searchHelper(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return this.searchHelper(prefix) != null;
    }

    private Node searchHelper(String word) {
        Node curr = this.root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.next[c - 'a'] == null)
                return null;
            curr = curr.next[c - 'a'];
        }
        return curr;
    }
}