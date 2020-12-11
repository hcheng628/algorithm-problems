package us.supercheng.algorithm.problems.leetcode.findandreplacepattern;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        pattern = this.ps(pattern);

        for (String w : words)
            if (this.sameP(this.ps(w), pattern))
                ret.add(w);

        return ret;
    }

    private boolean sameP(String s, String pat) {
        int len = s.length(),
                pLen = pat.length();

        if (len < pLen || len % pLen != 0)
            return false;

        for (int idx = 0; idx < len; idx++)
            if (s.charAt(idx) != pat.charAt(idx % pLen))
                return false;

        return true;
    }

    private String ps(String s) {
        int idx = 0;
        char c = 'a';
        Character[] used = new Character[26];
        StringBuilder sb = new StringBuilder();

        for (int i=0, len=s.length(); i<len; i++) {
            int ii = s.charAt(i) - 'a';
            if (used[ii] == null)
                used[ii] = (char) (c + idx++);
            sb.append(used[ii]);
        }

        return sb.toString();
    }

    public List<String> findAndReplacePatternMap(String[] words, String pattern) {
        Integer[] aToB = null,
                  bToA = null;
        List<String> ret = new ArrayList<>();
        int pLen = pattern.length();

        for (String w : words) {
            aToB = new Integer[26];
            bToA = new Integer[26];
            boolean isAdding = true;

            for (int i=w.length()-1; isAdding && i>-1; i--) {
                char c = w.charAt(i);
                int idx = c - 'a',
                        p = i % pLen;
                char cc = pattern.charAt(p);

                if (aToB[idx] == null) {
                    if (bToA[cc - 'a'] != null)
                        isAdding = false;
                    aToB[idx] = pattern.charAt(p) - 'a';
                    bToA[cc - 'a'] = c - 'a';
                } else if (aToB[idx] != cc-'a' || bToA[cc-'a'] != c-'a')
                    isAdding = false;
            }

            if (isAdding)
                ret.add(w);
        }

        return ret;
    }
}
