package us.supercheng.algorithm.problems.shortencodingofwords;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumLengthEncoding(String[] words) {
        int ret = 0;
        Trie trie = new Trie();
        Map<Trie, Integer> map = new HashMap<>();

        for (int i=0, len=words.length;i<len;i++) {
            String w = words[i];
            Trie curr = trie;
            for (int j=w.length()-1;j>-1;j--)
                curr = curr.getOrDef(w.charAt(j));
            map.put(curr, i);
        }

        for (Trie t : map.keySet())
            if (t.isEnd)
                ret += words[map.get(t)].length() + 1;

        return ret;
    }

    class Trie {
        Trie[] dict;
        boolean isEnd;

        Trie() {
            this.dict = new Trie[26];
            this.isEnd = true;
        }

        Trie getOrDef(char c) {
            int idx = c - 'a';

            if (this.dict[idx] == null) {
                this.dict[idx] = new Trie();
                if (this.isEnd)
                    this.isEnd = false;
            }

            return this.dict[idx];
        }
    }
}