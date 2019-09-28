package us.supercheng.algorithm.problems.replacewords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public String replaceWords(List<String> dict, String sentence) {
        String[] arr = sentence.split(" ");
        Set<String> set = new HashSet<>(dict);

        for (int i=0;i<arr.length;i++)
            for (int len = arr[i].length(), j=1;j<len;j++) {
                String s = arr[i].substring(0, j);
                if (set.contains(s)) {
                    arr[i] = s;
                    break;
                }
            }

        return String.join(" ", arr);
    }

    public String replaceWordsTrie(List<String> dict, String sentence) {
        String[] arr = sentence.split(" ");
        Trie trie = new Trie();

        for (String s : dict)
            this.addT(trie, s, 0);

        for (int i=0;i<arr.length;i++) {
            int len = this.findT(trie, arr[i], 0);
            if (len != arr[i].length())
                arr[i] = arr[i].substring(0, len+1);
        }

        return String.join(" ", arr);
    }

    private void addT(Trie trie, String s, int idx) {
        if (idx >= s.length())
            return;

        Node[] nodes = trie.nodes;
        char curr = s.charAt(idx);
        int charIdx = curr - 'a';

        if (nodes[charIdx] == null)
            nodes[charIdx] = new Node();
        if (idx == s.length()-1)
            nodes[charIdx].isWord = true;

        this.addT(nodes[charIdx].trie, s, idx+1);
    }

    private int findT(Trie trie, String s, int idx) {
        if (idx >= s.length())
            return s.length();

        Node[] nodes = trie.nodes;
        char curr = s.charAt(idx);
        Node n = nodes[curr - 'a'];

        if (n == null)
            return s.length();

        return n.isWord ? idx : this.findT(n.trie, s, idx+1);
    }

    class Node {

        Trie trie;
        boolean isWord;

        Node() {
            this.trie = new Trie();
        }
    }

    class Trie {

        Node[] nodes;

        Trie () {
            this.nodes = new Node[26];
        }
    }
}