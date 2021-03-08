package us.supercheng.algorithm.problems.algo.multistringsearch;

import java.util.*;

public class Program {

    // Time: O(n^3) Space: O(n)
    public static List<Boolean> multiStringSearch_Solution1(String bigString, String[] smallStrings) {
        List<Boolean> ret = new ArrayList<>();
        Map<Character, Set<Integer>> map = new HashMap<>();
        int bigLen = bigString.length();

        for (int i=0; i<bigLen; i++) {
            char b = bigString.charAt(i);
            if (!map.containsKey(b))
                map.put(b, new HashSet<>());
            map.get(b).add(i);
        }

        for (String s : smallStrings)
            ret.add(contains(s, map, bigString, bigLen));

        return ret;
    }

    private static boolean contains(String s, Map<Character, Set<Integer>> map, String bigS, int bigLen) {
        Character c = s.charAt(0);
        Set<Integer> set = map.get(c);
        if (set == null)
            return false;

        for (int idx : set) {
            boolean foundIt = true;

            for (int i=1, len=s.length(); foundIt && i<len; i++) {
                char cc = s.charAt(i);
                if (!(idx + i < bigLen && cc == bigS.charAt(idx + i)))
                    foundIt = false;
            }

            if (foundIt)
                return true;
        }

        return false;
    }

    public static List<Boolean> multiStringSearch_Solution2(String bigString, String[] smallStrings) {
        Trie trie = new Trie();
        List<Boolean> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();


        for (String s : smallStrings)
            trie.insert(s);

        for (int i=0, len=bigString.length(); i<len; i++)
            buildSet(trie, bigString, i, set);

        for (String s : smallStrings)
            ret.add(set.contains(s));

        return ret;
    }


    private static void buildSet(Trie trie, String s, int idx, Set<String> set) {
        TrieNode curr = trie.root;

        for (int i=idx, len=s.length(); i<len; i++) {
            char c = s.charAt(i);
            if (!curr.nexts.containsKey(c))
                return;

            curr = curr.nexts.get(c);
            if (curr.nexts.containsKey('*'))
                set.add(curr.s);
        }
    }


    static class TrieNode {
        Map<Character, TrieNode> nexts = new HashMap<>();
        String s;
    }

    static class Trie {
        TrieNode root;
        char endChar;

        Trie() {
            this.root = new TrieNode();
            this.endChar = '*';
        }

        void insert(String s) {
            TrieNode curr = this.root;

            for (int i=0, len=s.length(); i<len; i++) {
                char c = s.charAt(i);

                if (!curr.nexts.containsKey(c))
                    curr.nexts.put(c, new TrieNode());

                curr = curr.nexts.get(c);
            }

            curr.nexts.put(this.endChar, null);
            curr.s = s;
        }
    }

}
