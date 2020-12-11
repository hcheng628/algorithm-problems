package us.supercheng.algorithm.problems.leetcode.wordsubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ret = new ArrayList<>();
        int[] map = new int[26];

        for (String b : B) {
            int[] row = this.buildMap(b, new int[26]);
            for (int i=0; i<26; i++)
                map[i] = Math.max(map[i], row[i]);
        }

        for (String a : A) {
            int[] m = this.buildMap(a, new int[26]);
            boolean isAdding = true;

            for (int i=0; isAdding && i<26; i++)
                if (map[i] > m[i])
                    isAdding = false;

            if (isAdding)
                ret.add(a);
        }

        return ret;
    }

    private int[] buildMap(String s, int[] map) {
        for (int i=0, len=s.length(); i<len; i++)
            map[s.charAt(i) - 'a']++;
        return map;
    }
}