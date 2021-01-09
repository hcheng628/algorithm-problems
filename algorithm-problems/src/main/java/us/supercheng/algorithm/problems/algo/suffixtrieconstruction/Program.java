package us.supercheng.algorithm.problems.algo.suffixtrieconstruction;

import java.util.*;

public class Program {

    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {

        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i=0, len = str.length(); i<len; i++) {
                TrieNode node = this.root;
                for (int j=i; j<len; j++) {
                    char c = str.charAt(j);
                    Map<Character, TrieNode> map = node.children;

                    if (!map.containsKey(c))
                        map.put(c, new TrieNode());
                    node = map.get(c);

                    if (j == len - 1)
                        node.children.put(this.endSymbol, null);
                }
            }
        }

        public boolean contains(String str) {
            TrieNode curr = this.root;

            for (int i=0; i<str.length(); i++) {
                TrieNode next = curr.children.get(str.charAt(i));
                if (next == null)
                    return false;
                curr = next;
            }

            return curr.children.containsKey(this.endSymbol);
        }
    }
}
