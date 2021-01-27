package us.supercheng.algorithm.problems.leetcode.wordsearchii;

import java.util.*;

public class Solution {

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (String w : words)
            trie.add(w);

        for (int i=0, len=board.length; i<len; i++)
            for (int j=0, cLen=board[i].length; j<cLen; j++) {
                boolean[][] visited = new boolean[len][cLen];
                travel(board, visited, i, j, trie.root, set);
            }

        return new ArrayList<>(set);
    }

    private static void travel(char[][] board, boolean[][] visited, int x, int y, TrieNode node, Set<String> set) {
        if (visited[x][y])
            return;
        TrieNode curr = node.children.get(board[x][y]);
        if (curr == null)
            return;

        if (curr.word != null)
            set.add(curr.word);

        visited[x][y] = true;
        for (Integer[] next : getNexts(board, visited, x, y))
            travel(board, visited, next[0], next[1], curr, set);
        visited[x][y] = false;
    }

    private static List<Integer[]> getNexts(char[][] board, boolean[][] visited, int x, int y) {
        List<Integer[]> ret = new ArrayList<>();
        for (int i=-1; i<2; i++)
            for (int j=-1; j<2; j++) {
                if ((i == 0 && j == 0) || (i != 0 && j != 0))
                    continue;
                int nextX = x + i;
                int nextY = y + j;
                if (nextX > -1 && nextY > -1 && nextX < board.length && nextY < board[nextX].length && !visited[nextX][nextY])
                    ret.add(new Integer[]{nextX, nextY});
            }

        return ret;
    }

    static class TrieNode {
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void add(String s) {
            TrieNode node = this.root;
            for (int i=0, len=s.length(); i<len; i++) {
                char curr = s.charAt(i);
                Map<Character, TrieNode> children = node.children;
                if (!children.containsKey(curr))
                    children.put(curr, new TrieNode());
                node = children.get(curr);
            }
            node.word = s;
        }

        public void printWords() {
            Stack<TrieNode> stack = new Stack<>();
            for (Character c : this.root.children.keySet()) {
                TrieNode n = this.root.children.get(c);
                if (n != null)
                    stack.push(n);
            }

            while (!stack.isEmpty()) {
                TrieNode curr = stack.pop();
                if (curr == null)
                    continue;

                if (curr.word != null)
                    System.out.println(curr.word);

                for (Character c : curr.children.keySet()) {
                    TrieNode n = curr.children.get(c);
                    if (n != null)
                        stack.push(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("Cheng");
        trie.add("JetBrains\\IntelliJ IDEA Community Edition");
        trie.add("Edition");
        trie.add("IntelliJ IDEA Community Edition");
        trie.printWords();
    }
}