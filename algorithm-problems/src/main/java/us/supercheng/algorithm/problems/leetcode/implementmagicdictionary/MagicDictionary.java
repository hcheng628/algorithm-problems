package us.supercheng.algorithm.problems.leetcode.implementmagicdictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary {

    Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            int len = s.length();
            if (this.map.containsKey(len))
                this.map.get(len).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                this.map.put(len, list);
            }

        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() < 1)
            return false;

        int len = word.length();
        List<String> list = this.map.get(len);

        if (list != null)
            for (String s : list) {
                int count = 0;
                for (int i=0;i<len;i++)
                    if (s.charAt(i) != word.charAt(i)) {
                        count++;
                        if (count > 1)
                            continue;
                    }
                if (count == 1)
                    return true;
            }

        return false;
    }
}
